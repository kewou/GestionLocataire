/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beezyweb.kewouGame.exception;

import javax.persistence.EntityNotFoundException;
import javax.persistence.RollbackException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author frup73532
 */

@ControllerAdvice
@EnableWebMvc
@RestController
public class HandleException extends ResponseEntityExceptionHandler{
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @ExceptionHandler(EntityNotFoundException.class)    
    @ResponseBody
    public ExceptionInfo resourceNotFound(EntityNotFoundException e){ 
        logger.error(e.getMessage());
        return new  ExceptionInfo(HttpStatus.NOT_FOUND.value(), e.getMessage(), "La ressouce recherchée n'existe pas");
    }
    
    
    @ExceptionHandler(RollbackException.class)       
    @ResponseBody
    public ExceptionInfo badParam(RollbackException e){
        logger.error(e.getMessage());
        return new ExceptionInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Le (ou les) paramètres de la requete sont invalides ou manquant");
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)      
    @ResponseBody
    public ExceptionInfo runtime(DataIntegrityViolationException e){
        logger.error(e.getMessage());
        return new  ExceptionInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Cette adresse email est déja utilisée");       
    }
    
     
    @ExceptionHandler(DataAccessException.class)      
    @ResponseBody
    public ExceptionInfo badId(DataAccessException e){
        logger.error(e.getMessage());
        return new ExceptionInfo(HttpStatus.NOT_FOUND.value(), e.getMessage(), "l'id fourni est incorrect");
    }
    
    /*
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.CONFLICT)    
    @ResponseBody
    public ExceptionInfo sql(SQLException e){
        logger.error(e.getMessage());
        return new ExceptionInfo(HttpStatus.CONFLICT.value(), "SQL Exception", "Une erreur SQL a été détectée");
    }*/
                                    
    /*         
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   
    @ResponseBody
    public ExceptionInfo runtime(Exception e){
        logger.error(e.getMessage());
        return new  ExceptionInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), "Une erreur inconnu est survenue,veuillez contacter l'administrateur");       
    }*/
    

       
}
