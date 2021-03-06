package com.example.spring.service;

import com.example.spring.entity.ResponseResult;
import com.example.spring.entity.Users;
import com.example.spring.exception.RaceNotFoundException;
import com.example.spring.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Users addUser(Users race){
        return userRepo.save(race);
    }

    public Iterable<Users> getUsers(){
        return userRepo.findAll();
    }

    public Users getUser(Long id) throws RaceNotFoundException {
        Users user = userRepo.findById(id).get();
        if (user == null){
            throw new RaceNotFoundException("Race not found");
        }
        return user;
    }

    public List<Users> getByUsername(String username){
        List<Users> usersList = new ArrayList<>();
        usersList.add(userRepo.findByUsername(username));
        return usersList;
    }

    public void updateBalance(Long id, float newBalance){
        Users user = userRepo.findById(id).get();
        user.setBalance(newBalance);
        userRepo.save(user);
    }

    public void decreaseUserBalance(ResponseResult responseResult){
        Users user = userRepo.findById(Long.valueOf(responseResult.getIdFirst())).get();
        float newBalance = user.getBalance() - responseResult.getIdSecond();
        updateBalance(user.getID(), newBalance);
    }
}
