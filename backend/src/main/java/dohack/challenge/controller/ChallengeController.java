package dohack.challenge.controller;

import dohack.challenge.dto.ChallengeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/challenges")
public class ChallengeController {

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<String> getChallenges(@PathVariable Integer userId) {
        return new ResponseEntity(new ChallengeDTO(), HttpStatus.OK);
    }
}
