package springbootbackend.tournament.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="participant")
public class Participant {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer idTournoi;
    private String name;

    //participants à part

    // match à part

    public Participant(Integer idTournoi, String name){
        this.idTournoi = idTournoi;
        this.name = name;
    }

    public Participant(){

    }

    public Integer getId() { return this.id; }

    public Integer getIdTournoi(){
        return this.idTournoi;
    }

    public void setIdTournoi(Integer idTournoi){
        this.idTournoi = idTournoi;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
