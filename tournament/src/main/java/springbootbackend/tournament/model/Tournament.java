package springbootbackend.tournament.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tournament")
public class Tournament {

    @Id
    @GeneratedValue
    private Integer id;

    private String admin;
    private String name;
    private String description;
    private String state;

    public Tournament(String admin, String name, String description, String state){
        this.admin = admin;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public Tournament(){

    }

    public Integer getId(){
        return this.id;
    }

    public String getAdmin(){
        return this.admin;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public String getState(){
        return this.state;
    }
}
