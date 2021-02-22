/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beezyweb.kewouGame.service;

import com.beezyweb.kewouGame.dto.UserDTO;
import com.beezyweb.kewouGame.entities.User;
import java.util.List;

/**
 *
 * @author frup73532
 */
public interface UserService {

    User getUser(Long id);

    List<User> getAllUser();

    void delete(Long id);

    UserDTO add(UserDTO userDto);

    UserDTO update(Long id, UserDTO userDto);
}
