package springbootbackend.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootbackend.tournament.model.Match;
import springbootbackend.tournament.model.Participant;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {

    List<Match> findByIdtournoi(Integer idtournoi);
    List<Match> findByIdtournoiAndLevel(Integer idtournoi, Integer level);
    Match findMatchByIdtournoiAndId(Integer idtournoi, Integer id);


}
