package io.getarrays.userservice.repo;

import io.getarrays.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findUserById(Long id);
}
