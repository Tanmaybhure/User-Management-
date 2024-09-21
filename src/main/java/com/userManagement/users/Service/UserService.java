package com.userManagement.users.Service;

import com.userManagement.users.Exceptions.UserNotFoundException;
import com.userManagement.users.Model.User;
import com.userManagement.users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUserbyId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    public User updateUserById(User newuser, Long id) {
        return userRepository.findById(id)
                .map(user->{
                   user.setUsername(newuser.getUsername());
                   user.setName(newuser.getName());
                   user.setEmail(newuser.getEmail());
                   return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    public String deleteUser(Long id) {
        if(!userRepository.existsById(id)) throw new UserNotFoundException(id);
        else  userRepository.deleteById(id);
        return "User with Id " +id+" has deleted successfully";
    }
}
