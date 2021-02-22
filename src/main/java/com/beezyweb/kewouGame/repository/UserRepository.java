package com.beezyweb.kewouGame.repository;

import com.beezyweb.kewouGame.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author frup73532
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /*
    @Query("SELECT u FROM User u WHERE u.number = ?1")
    User findUserByNumber(String number);
     */
}
