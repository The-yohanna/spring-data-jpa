package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Role;
import com.johanna.springjpaecommerce.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyToManyBidirectionalTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRoleMethod() {

        User user = new User();
        user.setFirstName("Jon");
        user.setLastName("Fredrick");
        user.setEmail("jfredrick@gmail.com");
        user.setPassword("secret1");

        User user2 = new User();
        user2.setFirstName("Lyn");
        user2.setLastName("Grovback");
        user2.setEmail("lgrovback@gmail.com");
        user2.setPassword("secret2");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        admin.getUsers().add(user);
        admin.getUsers().add(user2);

        user.getRoles().add(admin);
        user2.getRoles().add(admin);

        roleRepository.save(admin);

    }

    @Test
    void fetchRoleMethod() {

        List<Role> roles = roleRepository.findAll();
        roles.forEach((r) -> {
            System.out.println(r.getName());
            r.getUsers().forEach((u) -> {
                System.out.println(u.getFirstName());
            });
        });
    }

}
