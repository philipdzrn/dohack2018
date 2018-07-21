package dohack.user.service;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.service.ChallengeService;
import dohack.user.dto.UserDTO;
import dohack.user.model.User;
import dohack.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChallengeService challengeService;

    public User getUser(String name, String password) {
        return userRepository.findFirstByNameAndPassword(name, password);
    }

    public UserDTO getUserDTOFromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setDescription(user.getDescription());
        userDTO.setNumberFinishedChallenges(user.getNumberFinishedChallenges());

        return userDTO;
    }
    
    public List<User> getAllUsers(){
        return (List)this.userRepository.findAll();
    }
    

    public User createNewUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        return userRepository.save(user);
    }
   
   /**
    * Get all user DTOs from a user list
    * @param users
    * @return
    */
    public List<UserDTO> getAllUserDTOs(List<User> users){
       // Create DTOs to send back to client
       List<UserDTO> userDTOS = new ArrayList<>();
       for(User user : users ){
          userDTOS.add(getUserDTOFromUser(user));
       }
       
       return userDTOS;
    }
}
