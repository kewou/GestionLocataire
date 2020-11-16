/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beezyweb.kewouGame.exception;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author frup73532
 */

public class ExceptionInfo implements Serializable{
    

    private static final long serialVersionUID =1L;
    private final int code;
    private final String cause;
    private final String message;
    
    public ExceptionInfo(int code,String cause,String message){
        this.code=code;
        this.cause=cause;
        this.message=message;        
    }
    
    public int getCode(){return code;}
    public String getCause(){return cause;}
    public String getMessage(){return message;}       
}
