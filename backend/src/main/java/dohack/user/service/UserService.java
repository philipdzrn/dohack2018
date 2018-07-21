package dohack.user.service;

import dohack.authentication.dto.LoginDTO;
import dohack.user.dto.UserDTO;
import dohack.user.model.User;
import dohack.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String name, String password) {
        return userRepository.findFirstByNameAndPassword(name, password);
    }

    public UserDTO getUserDTOFromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());

        return userDTO;
    }

    public User createNewUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        return userRepository.save(user);
    }


}
