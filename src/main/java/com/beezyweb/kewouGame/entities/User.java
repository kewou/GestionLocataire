
package com.beezyweb.kewouGame.entities;

import com.beezyweb.kewouGame.dto.UserDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author frup73532
 */

@Entity
@Table(name="users")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long id;
    
    @Column(name="first_name",nullable=false)
    private String name;
    
    @Column(name="last_name",nullable=false)
    private String lastName;
    
    
    public UserDTO convertToDTO(){
        UserDTO userDto = new UserDTO();
        userDto.setName(name);
        userDto.setLastName(lastName);
        return userDto;
    }

    
    
    
    
    
}
