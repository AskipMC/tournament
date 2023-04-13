package springbootbackend.tournament.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="match_tournament")
public class Match {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer idtournoi;

    private String state; //EN COURS, TERMINE ...

    private Integer participant1; //id
    private Integer result1;
    private Integer participant2; //id

    private Integer result2;

    private Integer level;
    private Integer nextMatch;

    public Match(Integer idtournoi, String state, Integer participant1, Integer result1, Integer participant2, Integer result2, Integer level, Integer nextMatch){
        this.idtournoi = idtournoi;
        this.state = state;
        this.participant1 = participant1;
        this.result1 = result1;
        this.participant2 = participant2;
        this.result2 = result2;
        this.level = level;
        this.nextMatch = nextMatch;
    }

    public Match(){

    }

    public Integer getWinner(){
        if(this.result2 > this.result1 ) return this.participant2;
        else if(this.result1 > this.result2 ) return this.participant1;
        else return this.participant2; //celui qui joue à l'exterieur gagne
    }

    public Integer getId() {
        return this.id;
    }
    public Integer getIdTournoi(){
        return this.idtournoi;
    }

    public void setIdTournoi(Integer v){
        this.idtournoi = idtournoi;
    }


    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public Integer getParticipant1(){
        return this.participant1;
    }

    public void setParticipant1(Integer participant1){
        this.participant1 = participant1;
    }

    public Integer getParticipant2(){
        return this.participant2;
    }

    public void setParticipant2(Integer participant2){
        this.participant2 = participant2;
    }

    public Integer getResult1(){
        return this.result1;
    }

    public void setResult1(Integer result1){
        this.result1 = result1;
    }

    public Integer getResult2(){
        return this.result2;
    }

    public void setResult2(Integer result2){
        this.result2 = result2;
    }

    public Integer getLevel(){
        return this.level;
    }

    public void setLevel(Integer result2){
        this.level = level;
    }

    public Integer getNextMatch(){
        return this.nextMatch;
    }

    public void setNextMatch(Integer result2){
        this.nextMatch = nextMatch;
    }
}
