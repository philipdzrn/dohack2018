package dohack.authentication.controller;

import dohack.authentication.dto.LoginDTO;
import dohack.user.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> login(LoginDTO loginDTO) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("Testperson");
        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

}
