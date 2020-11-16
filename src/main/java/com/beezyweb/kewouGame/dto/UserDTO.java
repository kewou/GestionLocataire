/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beezyweb.kewouGame.dto;

import com.beezyweb.kewouGame.entities.User;
import lombok.Data;

/**
 *
 * @author frup73532
 */
@Data
public class UserDTO {
    
    private String name;
    private String lastName;
    private String email;
    
    public User convertToEntity(){
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        return user;
    }
    
    
}
