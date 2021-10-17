package marti.vu.userservice;

import marti.vu.userservice.domain.Role;
import marti.vu.userservice.domain.User;
import marti.vu.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "Doctor Strange", "strange", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Iron man", "iron", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Captain America", "cap", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Thor", "thor", "1234", new ArrayList<>()));

            userService.addRoleToUser("strange", "ROLE_USER");
            userService.addRoleToUser("iron", "ROLE_USER");
            userService.addRoleToUser("cap", "ROLE_USER");
            userService.addRoleToUser("cap", "ROLE_ADMIN");
            userService.addRoleToUser("thor", "ROLE_USER");
        };
    }

}
