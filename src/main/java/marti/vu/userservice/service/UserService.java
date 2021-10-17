package marti.vu.userservice.service;

import marti.vu.userservice.domain.Role;
import marti.vu.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

    User findUserById(Long id);
}
