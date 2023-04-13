package springbootbackend.tournament.viewmodel;

public class UserView {

    private String pseudo;
    private boolean isConnected;

    //faire une enum pour les reponses : mauvais login, connecté ... ou statu boolean et message


    public UserView(String pseudo, boolean isConnected){
        this.pseudo = pseudo;
        this.isConnected = isConnected;
    }

    public UserView(){

    }

    public String getPseudo(){
        return this.pseudo;
    }

    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }

    public boolean isConnected(){
        return this.isConnected;
    }

    public void setConnected(boolean isConnected){
        this.isConnected = isConnected;
    }

}
