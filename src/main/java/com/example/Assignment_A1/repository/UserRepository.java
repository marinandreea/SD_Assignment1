package com.example.Assignment_A1.repository;

import com.example.Assignment_A1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface UserRepository extends CrudRepository<User,Integer>, JpaRepository<User,Integer> {

    Optional<User> findByUsernameAndPassword(String username,String password);
    Optional<User> findByUsername(String username);

}
