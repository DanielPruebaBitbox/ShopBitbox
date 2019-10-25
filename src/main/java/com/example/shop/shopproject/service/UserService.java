package com.example.shop.shopproject.service;

import com.example.shop.shopproject.exception.ResourceNotFoundException;
import com.example.shop.shopproject.model.User;
import com.example.shop.shopproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
            returnUser.setPassword(hashPassword( user.getPassword()));
            returnUser = userRepository.save(returnUser);
            return returnUser;
        } else{
            System.out.println("crear");
            user.setPassword(hashPassword(user.getPassword()));
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

    public static String  hashPassword(String password){
        String generatedPassword = null;
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = stringBuilder.toString();
            return generatedPassword;
        }  catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return "An error has ocurred hashing the password";

    }


}

