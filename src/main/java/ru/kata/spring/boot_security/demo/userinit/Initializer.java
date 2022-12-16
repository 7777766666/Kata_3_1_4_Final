package ru.kata.spring.boot_security.demo.userinit;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Initializer {

    private final UserServiceImpl userService;

    public Initializer(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        userService.addRole(role1);
        userService.addRole(role2);

        List<Role> roleAdmin = new ArrayList<>();
        List<Role> roleUser = new ArrayList<>();

        roleAdmin.add(role1);
        roleAdmin.add(role2);
        roleUser.add(role2);

        User adminUser1 = new User("AdminUser", "SuperAdminUser", 111, "adminUser@adminUser","adminUser" , roleAdmin);
        User user1 = new User("User", "MainUser", 55, "u@u","user", roleUser);
        User admin1 = new User("admin", "MainAdmin", 99, "admin@admin.ru","admin", roleAdmin);

        userService.add(admin1);
        userService.add(user1);
        userService.add(adminUser1);
    }
}
