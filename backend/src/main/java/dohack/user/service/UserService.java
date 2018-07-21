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

    /**
     * Get User by Name and Password
     *
     * @param name
     * @param password
     * @return
     */
    public User getUser(String name, String password) {
        return userRepository.findFirstByNameAndPassword(name, password);
    }

    /**
     * Get User
     *
     * @param userId
     * @return
     */
    public User getUser(Integer userId) {
        return userRepository.findById(userId).get();
    }

    /**
     * Update the User-Name
     *
     * @param userId
     * @param name
     */
    public void updateUserName(Integer userId, String name) {
        User user = getUser(userId);
        user.setName(name);
        userRepository.save(user);
    }

    /**
     * Update the User-Description
     *
     * @param userId
     * @param description
     */
    public void updateUserDescription(Integer userId, String description) {
        User user = getUser(userId);
        user.setDescription(description);
        userRepository.save(user);
    }

    /**
     * Get UserDTO from User
     *
     * @param user
     * @return
     */
    public UserDTO getUserDTOFromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setDescription(user.getDescription());

        return userDTO;
    }

    /**
     * Get all existing Users
     *
     * @return
     */
    public List<User> getAllUsers() {
        return (List) this.userRepository.findAll();
    }

    /**
     * Create a new user with name and password
     *
     * @param name
     * @param password
     * @return
     */
    public User createNewUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        return userRepository.save(user);
    }

    /**
     * Get all Challenges from a User
     *
     * @param userId
     * @return
     */
    public List<ChallengeDTO> getChallenges(Integer userId) {
        return challengeService.getChallengesByUser(userId);
    }

    /**
     * Get all user DTOs from a user list
     *
     * @param users
     * @return
     */
    public List<UserDTO> getAllUserDTOs(List<User> users) {
        // Create DTOs to send back to client
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(getUserDTOFromUser(user));
        }

        return userDTOS;
    }
}
