package dohack.user.repo;

import dohack.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findFirstByNameAndPassword(String name, String password);
}
