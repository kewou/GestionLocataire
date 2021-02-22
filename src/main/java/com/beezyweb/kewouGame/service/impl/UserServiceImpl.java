package com.beezyweb.kewouGame.service.impl;

import com.beezyweb.kewouGame.dto.UserDTO;
import com.beezyweb.kewouGame.entities.User;
import com.beezyweb.kewouGame.exception.NoDataFoundException;
import com.beezyweb.kewouGame.exception.UserNotFoundException;
import com.beezyweb.kewouGame.repository.UserRepository;
import com.beezyweb.kewouGame.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author frup73532
 */
@Service
public class UserServiceImpl implements UserService {

    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        User user = getUser(id);
        userRepository.delete(user);
    }

    @Override
    public UserDTO add(UserDTO userFront) {
        userRepository.save(userFront.convertToEntity());
        return userFront;
    }

    @Override
    public UserDTO update(Long id, UserDTO userFront) {
        User user = getUser(id);
        user.setName(userFront.getName());
        user.setLastName(userFront.getLastName());
        user.setEmail(userFront.getEmail());
        userRepository.save(user);
        return userFront;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = (List<User>) userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoDataFoundException();
        }
        return users;
    }

    private String generateNumber() {
        String res = "";
        Random rand = new Random();
        res += alphabet.charAt(rand.nextInt(10));
        res += String.valueOf(rand.nextInt(10));
        res += alphabet.charAt(rand.nextInt(10));
        res += String.valueOf(rand.nextInt(10));
        res += alphabet.charAt(rand.nextInt(10));
        return res;
    }

}
