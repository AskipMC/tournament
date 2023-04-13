package springbootbackend.tournament.viewmodel;

public class TournamentCreate {

    private String admin;
    private String name;
    private String description;

    private String[] participants;

    public TournamentCreate(String admin, String name, String description, String[] participants){
        this.admin = admin;
        this.name = name;
        this.description = description;
        this.participants = participants;
    }

    public TournamentCreate(){

    }

    public String getAdmin(){
        return this.admin;
    }

    public void setAdmin(String admin){
        this.admin = admin;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getParticipants(){
        return this.participants;
    }

    public void setParticipants(String[] participants){
        this.participants = participants;
    }
}
