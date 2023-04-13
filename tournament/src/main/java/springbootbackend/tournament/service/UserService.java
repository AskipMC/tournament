package springbootbackend.tournament.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootbackend.tournament.model.User;
import springbootbackend.tournament.repository.UserRepository;
import springbootbackend.tournament.viewmodel.UserLogin;
import springbootbackend.tournament.viewmodel.UserView;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean RegisterUser(UserLogin user) {

        if(!userRepository.findUsersByPseudo(user.getPseudo()).isPresent()){
            User user_db = new User(user.getPseudo(), user.getPassword());
            userRepository.save(user_db);
            return true;
        }

        return false;
    }

    @Override
    public UserView LoginUser(UserLogin user) {

        Optional<User> user_optional = userRepository.findUsersByPseudo(user.getPseudo());

        if(user_optional.isPresent()) {
            User user_db = user_optional.get();
            if(user_db.getPassword().equals(user.getPassword())) return new UserView(user_db.getPseudo(), true);
            else return new UserView("",false);
        }

        else {
            return new UserView("",false);
        }
    }


}
