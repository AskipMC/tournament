package springbootbackend.tournament.viewmodel;

import springbootbackend.tournament.model.Match;

import java.util.ArrayList;
import java.util.List;

public class TournamentView {

    private Integer id;
    private String admin;

    private String name;
    private String description;

    private String state;
    private List<String> participants = new ArrayList<String>();
    private List<MatchView> matchs = new ArrayList<MatchView>();

    public TournamentView(Integer id, String admin, String name, String description, String state, List<String> participants, List<MatchView> matchs){
        this.id = id;
        this.admin = admin;
        this.name = name;
        this.description = description;
        this.state = state;
        this.participants = participants;
        this.matchs = matchs;
    }

    public TournamentView(){

    }

    public Integer getId(){
        return this.id;
    }

    public String getAdmin(){ return this.admin; }
    public void setAdmin(String admin){ this.admin = admin; }

    public String getName(){ return this.name; }
    public void setName(String name){ this.name = admin; }
    public String getDescription(){ return this.description; }
    public void setDescription(String description){ this.description = description; }
    public String getState(){ return this.state; }
    public void setState(String admin){ this.state = state; }
    public List<String> getParticipants(){ return this.participants; }
    public void setParticipants(List<String> participants){ this.participants = participants; }
    public List<MatchView> getMatchs(){ return this.matchs; }
    public void setMatchs(List<MatchView> matchs){ this.matchs = matchs; }



}
