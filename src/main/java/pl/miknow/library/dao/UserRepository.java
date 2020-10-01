package pl.miknow.library.dao;

import org.springframework.data.repository.CrudRepository;
import pl.miknow.library.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
