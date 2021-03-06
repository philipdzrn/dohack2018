package dohack.authentication.controller;

import dohack.authentication.dto.LoginDTO;
import dohack.authentication.service.AuthenticationService;
import dohack.authentication.util.UnauthorizedException;
import dohack.user.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {

        if (!areRelevantFieldsSet(loginDTO)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        try {
            UserDTO login = authenticationService.login(loginDTO);
            return new ResponseEntity<>(login, HttpStatus.OK);
        } catch (UnauthorizedException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> register(@RequestBody LoginDTO loginDTO) {

        if (!areRelevantFieldsSet(loginDTO)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserDTO login = authenticationService.register(loginDTO);

        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    private boolean areRelevantFieldsSet(LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getUsername()) || StringUtils.isEmpty(loginDTO.getPassword())) {
            return false;
        }

        return true;
    }
}
