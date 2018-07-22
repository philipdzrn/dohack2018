package dohack.userHasFriends.repo;

import dohack.user.model.User;
import dohack.userHasFriends.model.UserHasFriends;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserHasFriendsRepository extends CrudRepository<UserHasFriends, Integer> {

    List<User> findByUser(User user);

    void deleteUserHasFriendsByUserAndFriend( User user, User friend );
}
