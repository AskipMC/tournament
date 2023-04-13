package springbootbackend.tournament.service;

import springbootbackend.tournament.model.Tournament;
import springbootbackend.tournament.viewmodel.TournamentCreate;
import springbootbackend.tournament.viewmodel.TournamentView;
import springbootbackend.tournament.viewmodel.UserLogin;

import java.util.List;

public interface ITournamentService {

    public boolean CreateTournament(TournamentCreate user);
    public List<TournamentView> GetAllTournaments();
    public List<TournamentView> GetPersonalTournaments(String pseudo);

    public boolean GenerateMatchs(Integer idtournoi, Integer level);
    public boolean SaveMatch(TournamentView tournament);
}
