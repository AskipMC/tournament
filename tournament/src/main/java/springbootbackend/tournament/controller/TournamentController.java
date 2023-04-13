package springbootbackend.tournament.controller;

import org.springframework.web.bind.annotation.*;
import springbootbackend.tournament.service.TournamentService;
import springbootbackend.tournament.viewmodel.TournamentCreate;
import org.springframework.beans.factory.annotation.Autowired;
import springbootbackend.tournament.viewmodel.TournamentView;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/Tournament/Tournament")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;


    @PostMapping("/Create")
    public boolean CreateTournament(@RequestBody TournamentCreate tournament){
        return tournamentService.CreateTournament(tournament);
    }

    @GetMapping("/All")
    public List<TournamentView> GetAllTournaments(){
        return tournamentService.GetAllTournaments();
    }

    @GetMapping("/Personal/{pseudo}")
    public List<TournamentView> GetPersonalTournaments(@PathVariable("pseudo") String pseudo){
        return tournamentService.GetPersonalTournaments(pseudo);
    }

    @GetMapping("/GenerateMatchs/{idtournoi}/{level}")
    public boolean GenerateMatchs(@PathVariable("idtournoi") Integer idtournoi, @PathVariable("level") Integer level){
        return tournamentService.GenerateMatchs(idtournoi, level);
    }

    @PostMapping("/SaveMatch")
    public boolean SaveMatch(@RequestBody TournamentView tournament){
        return tournamentService.SaveMatch(tournament);
    }
}
