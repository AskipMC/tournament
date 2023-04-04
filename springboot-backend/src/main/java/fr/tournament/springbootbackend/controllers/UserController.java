package fr.tournament.springbootbackend.controllers;

import fr.tournament.springbootbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081") //attention à bien modif le port en fonction de celui du Vuejs
@RequestMapping("/Tournament/User")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public void CreateUser(){
        System.out.println("API Register");
        return;
    }

    @GetMapping("/login")
    public String LoginUser(){
        System.out.println("API Login");
        return "saltu les amis";
    }

}
