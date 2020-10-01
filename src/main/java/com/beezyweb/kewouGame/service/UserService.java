/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beezyweb.kewouGame.service;

import com.beezyweb.kewouGame.dto.UserDTO;
import java.util.List;

/**
 *
 * @author frup73532
 */
public interface UserService {
    
    UserDTO getUser(Long id); 
    
    List<UserDTO> getAllUser();
    
    void delete(Long id);
    
    UserDTO add(UserDTO u);
    
    UserDTO update(UserDTO u);
    
}
