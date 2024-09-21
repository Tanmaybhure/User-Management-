package com.userManagement.users.Controller;

import com.userManagement.users.Model.User;
import com.userManagement.users.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public User newUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/user")
    public List<User> getUser(){
        return userService.getUser();
    }
    @GetMapping("/user/{id}")
    public User getUserByid(@PathVariable Long id){
        return userService.getUserbyId(id);
    }
    @PutMapping("/user/{id}")
    public User updateUserById(@RequestBody User newUser, @PathVariable Long id){
        return userService.updateUserById(newUser,id);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
