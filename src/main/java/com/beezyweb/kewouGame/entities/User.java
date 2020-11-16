
package com.beezyweb.kewouGame.entities;

import com.beezyweb.kewouGame.dto.UserDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author frup73532
 */

@Entity
@Table(name="users")
@Data
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long id;
    
    @NotEmpty(message="Please un nom")
    @Size(min = 2, max = 10)
    @Column(name="name",nullable=false)
    private String name;
    
    @NotEmpty(message="Please un prénom")
    @Size(min = 2, max = 10)
    @Column(name="last_name",nullable=false)
    private String lastName;
    
    @NotEmpty(message="Please un email")
    @Column(name="email",nullable=false,unique = true)
    @javax.validation.constraints.Email
    private String email;
    
    
    public UserDTO convertToDTO(){
        UserDTO userDto = new UserDTO();
        userDto.setName(name);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        return userDto;
    }
 
}
