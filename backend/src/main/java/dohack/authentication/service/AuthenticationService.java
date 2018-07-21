package dohack.authentication.service;

import dohack.authentication.dto.LoginDTO;
import dohack.authentication.util.UnauthorizedException;
import dohack.user.dto.UserDTO;
import dohack.user.model.User;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    public UserDTO login(LoginDTO loginDTO) {

        User user = userService.getUser(loginDTO.getUsername(), loginDTO.getPassword());

        if (user == null) {
            throw new UnauthorizedException();
        }


        return userService.getUserDTOFromUser(user);
    }

    public UserDTO register(LoginDTO loginDTO) {
        User user = userService.getUser(loginDTO.getUsername(), loginDTO.getPassword());
        if(user != null) {
            return userService.getUserDTOFromUser(user);
        }

        User newUser = userService.createNewUser(loginDTO.getUsername(), loginDTO.getPassword());

        return userService.getUserDTOFromUser(newUser);
    }


}
