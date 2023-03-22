package com.example.Assignment_A1.service;

import com.example.Assignment_A1.model.User;
import com.example.Assignment_A1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public List<User> getAllUsers(){
       // return users;
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(u-> users.add(u));
        return users;
    }

    public Optional<User> getUserById(int id){
        //return cashiers.stream().filter(u->u.getIdUser()==id).findFirst().get();
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username){
        //return cashiers.stream().filter(u->u.getIdUser()==id).findFirst().get();
        List<User> users = getAllUsers();
        for(User u:users){
            if(u.getUsername().equals(username)){

                return Optional.of(u);

            }
        }

        return null;
    }

    public void addUser(User user){
       //users.add(user);
        String encP = user.encryptedPassword(user.getPassword());
        user.setPassword(encP);
        userRepository.save(user);
    }

    //update to change only the role
    public void updateUser(int id, User user){
        userRepository.save(user);
    }

    public void deleteUser(int id){
       userRepository.deleteById(id);
    }




}
