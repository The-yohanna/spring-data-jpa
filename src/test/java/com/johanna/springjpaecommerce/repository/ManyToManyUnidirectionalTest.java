package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Role;
import com.johanna.springjpaecommerce.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectionalTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserMethod() {

        User user = new User();
        user.setFirstName("Jon");
        user.setLastName("Fredrick");
        user.setEmail("jfredrick@gmail.com");
        user.setPassword("secrete");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);

        userRepository.save(user);

    }

    @Test
    void updateUserMethod() {

        User user = userRepository.findById(1L).get();
        user.setFirstName("Jonas");
        user.setPassword("robustpass");

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");

        user.getRoles().add(roleUser);

        userRepository.save(user);

    }

    @Test
    void fetchUserMethod() {

        User user = userRepository.findById(1L).get();
        System.out.println(user.getEmail());
        user.getRoles().forEach((r) -> {
            System.out.println(r.getName());
        });

    }

    @Test
    void deleteUserMethod() {

        userRepository.deleteById(1L);

    }
}
