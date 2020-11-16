package com.beezyweb.kewouGame.controllers;

import com.beezyweb.kewouGame.dto.UserDTO;
import com.beezyweb.kewouGame.entities.User;
import com.beezyweb.kewouGame.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author frup73532
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping(path="")
    public List<UserDTO>  getAllUsers() throws Exception{
        List<UserDTO> listUserDTO = new ArrayList<>();
        for(User user:userService.getAllUser()){
            listUserDTO.add(user.convertToDTO());
        }
        return listUserDTO;
    }
    
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") long id) {        
        return userService.getUser(id).convertToDTO();
    }
    
    @PostMapping(path="/add") 
    public UserDTO  addNewUser (@Valid @RequestBody UserDTO userDto) {
        return userService.add(userDto);
    }
    
    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") long id){       
        userService.delete(id);
    }
    
    @PutMapping(path="/{id}")
    public void updateUser(@PathVariable("id") long id,@RequestBody UserDTO userDtoFront){              
        userService.update(id,userDtoFront);
    }
  
}
