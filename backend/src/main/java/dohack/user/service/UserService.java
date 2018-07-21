package dohack.user.service;

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
}
