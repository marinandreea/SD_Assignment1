package com.example.Assignment_A1.controller;

import com.example.Assignment_A1.model.User;
import com.example.Assignment_A1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableMethodSecurity
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/useeer")
    public String testare(){
        return "Merge";
    }

    @RequestMapping("/user/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<User> getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/user/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void addUser(@RequestBody User user){
         userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/user/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateUser(@RequestBody User user, @PathVariable int id){
        userService.updateUser(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/user/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }


}
