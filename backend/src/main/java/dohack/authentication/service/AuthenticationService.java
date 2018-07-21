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

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());

        return userDTO;
    }
}
