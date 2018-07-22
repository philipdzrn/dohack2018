package dohack.userHasFriends.service;

import dohack.user.dto.UserDTO;
import dohack.user.model.User;
import dohack.user.service.UserService;
import dohack.userHasFriends.model.UserHasFriends;
import dohack.userHasFriends.repo.UserHasFriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserHasFriendsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserHasFriendsRepository userHasFriendsRepository;

    public List<User> getFriends( Integer userId ) {
        return userHasFriendsRepository.findByUser(userService.getUser(userId));
    }

    public List<UserDTO> getFriendDTOs(Integer userId) {
        List<UserDTO> friendDTOs = new ArrayList<UserDTO>();
        for( User friend : getFriends(userId)) {
            friendDTOs.add( userService.getUserDTOFromUser(friend));
        }
        return friendDTOs;
    }

    public UserHasFriends addFriend( Integer userId, Integer friendId ) {
        User user = userService.getUser(userId);
        User friend = userService.getUser(friendId);
        UserHasFriends userHasFriends = new UserHasFriends(user, friend);
        return userHasFriendsRepository.save(userHasFriends);
    }

    public void removeFriend( Integer userId, Integer friendId ) {
        User user = userService.getUser(userId);
        User friend = userService.getUser(friendId);
        userHasFriendsRepository.deleteUserHasFriendsByUserAndFriend(user,friend);
    }
}
