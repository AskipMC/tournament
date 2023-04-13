package springbootbackend.tournament.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootbackend.tournament.service.UserService;
import springbootbackend.tournament.viewmodel.UserLogin;
import springbootbackend.tournament.viewmodel.UserView;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/Tournament/User")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/Register")
    public boolean CreateUser(@RequestBody UserLogin user){
        return userService.RegisterUser(user);
    }

    @PostMapping("/Login")
    public UserView LoginUser(@RequestBody UserLogin user){
        return userService.LoginUser(user);
    }
}
