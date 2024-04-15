package spring.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.permission.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String userName);


}
