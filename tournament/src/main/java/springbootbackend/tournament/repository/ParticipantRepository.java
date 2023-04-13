package springbootbackend.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootbackend.tournament.model.Participant;
import springbootbackend.tournament.model.Tournament;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

     List<Participant> findParticipantsByIdTournoi(Integer idTournoi);
     Participant findParticipantById(Integer id);

}
