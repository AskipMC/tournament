package springbootbackend.tournament.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_tournament")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String pseudo;
    private String password;

    public User(String pseudo, String password){
        this.pseudo = pseudo;
        this.password = password;
    }

    public User() {

    }

    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }

    public String getPseudo(){
        return this.pseudo;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }



}
