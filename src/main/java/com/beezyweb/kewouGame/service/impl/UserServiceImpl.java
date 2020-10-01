
package com.beezyweb.kewouGame.service.impl;

import com.beezyweb.kewouGame.dto.UserDTO;
import com.beezyweb.kewouGame.entities.User;
import com.beezyweb.kewouGame.repository.UserRepository;
import com.beezyweb.kewouGame.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author frup73532
 */

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUser(Long id) {
       return userRepository.getOne(id).convertToDTO();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO add(UserDTO userDto) {
        userRepository.save(userDto.convertToEntity());
        return userDto;
    }

    @Override
    public UserDTO update(UserDTO userDto) {
        userRepository.save(userDto.convertToEntity());
        return userDto;
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> listUserDto = new ArrayList<>();
        for(User user: userRepository.findAll()){
            listUserDto.add(user.convertToDTO());
        }
        return listUserDto;
    }
    
}
