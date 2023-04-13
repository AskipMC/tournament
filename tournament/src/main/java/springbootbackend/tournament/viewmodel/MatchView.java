package springbootbackend.tournament.viewmodel;

public class MatchView {

    private Integer id;
    private Integer idtournoi;
    private String participant1;
    private String participant2;
    private Integer result1;
    private Integer result2;
    private String state;
    private Integer nextMatch;
    private Integer level;


    public MatchView(Integer id, Integer idtournoi, String participant1, String participant2, Integer result1, Integer result2, String state, Integer nextMatch, Integer level){
        this.id = id;
        this.idtournoi = idtournoi;
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.result1 = result1;
        this.result2 = result2;
        this.state = state;
        this.nextMatch = nextMatch;
        this.level = level;
    }

    public MatchView(){

    }

    public Integer getId() { return this.id; }

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

    public String getParticipant1(){
        return this.participant1;
    }

    public void setParticipant1(String participant1){
        this.participant1 = participant1;
    }

    public String getParticipant2(){
        return this.participant2;
    }

    public void setParticipant2(String participant2){
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
