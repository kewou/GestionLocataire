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
public class BadParameterException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    public BadParameterException(final String message, final Throwable cause){
        super(message,cause);
    }
    
    public BadParameterException(final String message){
        super(message);
    }
    
}
