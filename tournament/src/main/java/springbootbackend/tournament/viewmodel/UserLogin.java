package springbootbackend.tournament.viewmodel;

public class UserLogin {

    private String pseudo;
    private String password;

    public UserLogin(String pseudo, String password){
        this.pseudo = pseudo;
        this.password = password;
    }

    public UserLogin(){

    }

    public String getPseudo(){
        return this.pseudo;
    }

    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
