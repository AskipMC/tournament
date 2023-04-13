package springbootbackend.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootbackend.tournament.model.Tournament;

import java.util.List;
import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    Optional<Tournament> findTournamentByAdminAndNameAndDescription(String admin, String name, String description);
    List<Tournament> findAll();
    List<Tournament> findAllByAdmin(String admin);
    Tournament findTournamentById(Integer id);


}
