/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beezyweb.kewouGame.User;

import com.beezyweb.kewouGame.entities.User;
import com.beezyweb.kewouGame.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 *
 * @author frup73532
 */
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    public void find_all_users() {
        Iterable<User> users = userRepo.findAll();
        int nbUser = 2;
        Assertions.assertThat(users).hasSize(nbUser);
    }

    @Test
    public void find_one_user() {
        User user;
        user = userRepo.findById(Long.valueOf(1)).get();
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getName()).isEqualTo("Joel");
    }

}
