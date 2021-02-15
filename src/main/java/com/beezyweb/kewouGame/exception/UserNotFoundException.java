/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beezyweb.kewouGame.exception;

/**
 *
 * @author frup73532
 */
public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(Long id){
        super(String.format("User with name %d not found", id));
    }
    
}
