package com.aint.commerce.services;

import com.aint.commerce.datarepository.AuthenticationRepository;
import com.aint.commerce.datarepository.ProductRepository;
import com.aint.commerce.entity.Product;
import com.aint.commerce.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    public AuthenticationRepository authenticationRepository;

    public UserProfile findByUserEmail(String userProfile){
        return  authenticationRepository.findByUserName(userProfile);
    }

    public void createProfile(UserProfile userProfile){
        authenticationRepository.save(userProfile);
    }

    public Optional<UserProfile> findUserProfileById(Integer id){
        return authenticationRepository.findById(id);
    }

    public UserProfile updateUserProfile(UserProfile userProfile, Integer id){
        return authenticationRepository.save(userProfile);
    }

    public void deleteProduct(Integer id){
        authenticationRepository.deleteById(id);
    }

}
