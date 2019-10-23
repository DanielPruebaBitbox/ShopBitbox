package com.example.shop.shopproject.Service;

import com.example.shop.shopproject.exception.ResourceNotFoundException;
import com.example.shop.shopproject.exception.GlobalExceptionHandler;
import com.example.shop.shopproject.exception.ErrorDetails;
import com.example.shop.shopproject.model.User;
import com.example.shop.shopproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> userList = userRepository.findAll();

        if(userList.size() > 0) return userList;
        else return new ArrayList<User>();
    }

    public User getUserById(Long id) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return user.get();
        else throw new ResourceNotFoundException("No user found with given id");

    }

    public User createOrUpdateUser(User user, long userId) throws ResourceNotFoundException{

        Optional<User> newUser = userRepository.findById(userId);
        if(newUser.isPresent()) {
            //TODO update fields
            User returnUser  = newUser.get();
            returnUser.setFirstName(user.getFirstName());
            returnUser.setLastName(user.getLastName());
            returnUser.setRole(user.getRole());
            returnUser.setEmail(user.getEmail());
            return returnUser;
        } else{
            user = userRepository.save(user);
            return user;
        }

    }

    public void deleteUser(Long id) throws ResourceNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
        }
        else throw new ResourceNotFoundException("No user found with given id");
    }
}

