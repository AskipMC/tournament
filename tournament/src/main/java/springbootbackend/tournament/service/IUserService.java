package springbootbackend.tournament.service;

import springbootbackend.tournament.viewmodel.UserLogin;
import springbootbackend.tournament.viewmodel.UserView;

public interface IUserService {

    public boolean RegisterUser(UserLogin user);

    public UserView LoginUser(UserLogin user);
}
