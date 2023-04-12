package com.gabrielfernandes.estudo.redis.repository;

import com.gabrielfernandes.estudo.redis.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userTest() {
        User user = new User();
        user.setId("1");
        user.setName("User 1");
        user.setEmail("user@test.com");
        user.setPhone("99999999");

        userRepository.save(user);

        User retrievedUser =
                userRepository.findById("1").get();

        Assertions.assertEquals("1", retrievedUser.getId());
        Assertions.assertEquals("User 1", retrievedUser.getName());
        Assertions.assertEquals("user@test.com", retrievedUser.getEmail());
        Assertions.assertEquals("99999999", retrievedUser.getPhone());
        System.out.println(retrievedUser);

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        Assertions.assertEquals(1, users.size());

        userRepository.deleteById("1");
        Optional<User> retrievedUserOptional =
                userRepository.findById("1");
        Assertions.assertFalse(retrievedUserOptional.isPresent());
    }
}
