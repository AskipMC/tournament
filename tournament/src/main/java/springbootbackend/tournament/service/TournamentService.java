package springbootbackend.tournament.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootbackend.tournament.model.Participant;
import springbootbackend.tournament.model.Tournament;
import springbootbackend.tournament.model.Match;
import springbootbackend.tournament.repository.MatchRepository;
import springbootbackend.tournament.repository.ParticipantRepository;
import springbootbackend.tournament.repository.TournamentRepository;
import springbootbackend.tournament.viewmodel.MatchView;
import springbootbackend.tournament.viewmodel.TournamentCreate;
import springbootbackend.tournament.viewmodel.TournamentView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService implements ITournamentService{

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public boolean CreateTournament(TournamentCreate tournament_create) {

        Tournament tournament = new Tournament(
                tournament_create.getAdmin(),
                tournament_create.getName(),
                tournament_create.getDescription(),
                "A VENIR"
        );
        tournamentRepository.save(tournament);

        for(String participant : tournament_create.getParticipants()){
            participantRepository.save(
                    new Participant(tournament.getId(), participant)
            );
        }

        this.GenerateMatchs(tournament.getId(), 1);

        return true;
    }

    @Override
    public List<TournamentView> GetAllTournaments(){
        List<Tournament> tournaments = tournamentRepository.findAll();
        List<TournamentView> tournamentView = new ArrayList<TournamentView>();

        for(int i=0; i<tournaments.size();i++){
            tournamentView.add(this.GenerateTournamentView(tournaments.get(i)));
        }

        return tournamentView;
    }

    @Override
    public List<TournamentView> GetPersonalTournaments(String pseudo){
        List<Tournament> tournaments = tournamentRepository.findAllByAdmin(pseudo);
        List<TournamentView> tournamentView = new ArrayList<TournamentView>();

        for(int i=0; i<tournaments.size();i++){
            tournamentView.add(this.GenerateTournamentView(tournaments.get(i)));
        }

        return tournamentView;
    }

    @Override
    public boolean GenerateMatchs(Integer idtournoi, Integer level){

        Tournament tournament = tournamentRepository.findTournamentById(idtournoi);
        List<Participant> participants = participantRepository.findParticipantsByIdTournoi(idtournoi);
        List<String> participants_string = new ArrayList<String>();
        for(int j=0; j<participants.size();j++) {
            participants_string.add(participants.get(j).getName());
        }

        if(tournament==null) return false;

        if(level==1){ //Génération des premiers matchs

            for(int i=0; i<participants.size();i+=2){
                if(i==participants.size()-1){
                    matchRepository.save(new Match(
                            idtournoi,
                            "A VENIR",
                            participants.get(i).getId(),
                            1, //match win 1-0 par defaut
                            null, //pas d'adversaire
                            null,
                            1,
                            null
                    ));
                }
                else {
                    matchRepository.save(new Match(
                            idtournoi,
                            "A VENIR",
                            participants.get(i).getId(),
                            null,
                            participants.get(i+1).getId(),
                            null,
                            1,
                            null
                    ));
                }
            }


        }
        else {
            List<Match> previousMatch = matchRepository.findByIdtournoiAndLevel(idtournoi, level - 1);
            for (int i = 0; i < previousMatch.size(); i += 2) {

                if (i == previousMatch.size() - 1) {

                    Match previous1 = previousMatch.get(i);
                    Integer win1 = previous1.getWinner();

                    Match new_match = new Match(
                            idtournoi,
                            "A VENIR",
                            win1,
                            1,
                            null,
                            null,
                            level,
                            null
                    );

                    matchRepository.save(new_match);

                    previous1.setNextMatch(new_match.getId());
                    matchRepository.save(previous1);

                    matchRepository.save(new Match(
                            idtournoi,
                            "A VENIR",
                            participants.get(i).getId(),
                            1, //match win 1-0 par defaut
                            null, //pas d'adversaire
                            null,
                            level,
                            null
                    ));
                } else {

                    Match previous1 = previousMatch.get(i);
                    Match previous2 = previousMatch.get(i + 1);

                    Integer win1 = previous1.getWinner();
                    Integer win2 = previous2.getWinner();

                    Match new_match = new Match(
                            idtournoi,
                            "A VENIR",
                            win1,
                            null,
                            win2,
                            null,
                            level,
                            null
                    );

                    matchRepository.save(new_match);

                    previous1.setNextMatch(new_match.getId());
                    matchRepository.save(previous1);
                    previous2.setNextMatch(new_match.getId());
                    matchRepository.save(previous2);


                }
            }
        }

        return true;
    }

    public boolean SaveMatch(TournamentView tournament){
        for(int i=0; i< tournament.getMatchs().size();i++){
            MatchView matchview = tournament.getMatchs().get(i);
            Match match = matchRepository.findMatchByIdtournoiAndId(tournament.getId(), matchview.getId());
            match.setResult1(matchview.getResult1());
            match.setResult2(matchview.getResult2());
            if(match.getResult1() != null && match.getResult2() != null) match.setState("TERMINE");
            matchRepository.save(match);
        }
        return true;
    }

    public MatchView GenerateMatchView(Match match){

        Participant participant1 = participantRepository.findParticipantById(match.getParticipant1());
        Participant participant2 = participantRepository.findParticipantById(match.getParticipant2());
        return new MatchView(
                match.getId(),
                match.getIdTournoi(),
                participant1.getName(),
                participant2.getName(),
                match.getResult1(),
                match.getResult2(),
                match.getState(),
                match.getNextMatch(),
                match.getLevel()
        );
    }

    public TournamentView GenerateTournamentView(Tournament tournament){

        List<Participant> participants = participantRepository.findParticipantsByIdTournoi(tournament.getId());
        List<String> participants_string = new ArrayList<String>();
        for(int j=0; j<participants.size();j++){
            participants_string.add(participants.get(j).getName());
        }

        List<Match> matchs = matchRepository.findByIdtournoi(tournament.getId());
        List<MatchView> matchsview = new ArrayList<MatchView>();
        for(int a=0; a<matchs.size();a++){
            matchsview.add(this.GenerateMatchView(matchs.get(a)));
        }

        return new TournamentView(
                tournament.getId(),
                tournament.getAdmin(),
                tournament.getName(),
                tournament.getDescription(),
                tournament.getState(),
                participants_string,
                matchsview
        );
    }


}
