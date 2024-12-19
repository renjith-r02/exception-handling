package com.example.demo.exceptionhandling.service;


import com.example.demo.exceptionhandling.entity.UserEntity;
import com.example.demo.exceptionhandling.exception.DemoAPIException;
import com.example.demo.exceptionhandling.exception.DemoDataException;
import com.example.demo.exceptionhandling.exception.DemoEventException;
import com.example.demo.exceptionhandling.exception.DemoException;
import com.example.demo.exceptionhandling.model.LoginDTO;
import com.example.demo.exceptionhandling.model.User;
import com.example.demo.exceptionhandling.util.UserRegisteredEvent;
import com.example.demo.exceptionhandling.repository.UserRegistrationRepository;
import com.example.demo.exceptionhandling.util.EmailValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserRegistrationService {

    private UserRegistrationRepository userRegistrationRepository;

    // @Transactional
    private EmailValidator emailValidator;

    LoginService loginService;

    RestTemplate restTemplate;

    ApplicationEventPublisher applicationEventPublisher;

    UserRegistrationService(@Autowired LoginService loginService, @Autowired EmailValidator emailValidator, @Autowired UserRegistrationRepository userRegistrationRepository, @Autowired ApplicationEventPublisher applicationEventPublisher, @Autowired RestTemplate restTemplate) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.userRegistrationRepository = userRegistrationRepository;
        this.emailValidator = emailValidator;
        this.loginService = loginService;
        this.restTemplate = restTemplate;
    }


    public void registerUser(User user) throws DemoException {
        saveUserEntity(user);
        registerEvents(user);
        invokeLoginApi(user);
    }

    public ResponseEntity<String> invokeLoginApi(User user) throws DemoAPIException {
        try {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(user.getUsername());
        loginDTO.setPassword(user.getPassword());
        String url = "http://localhost:8080/api/auth/login";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<LoginDTO> request = new HttpEntity<>(loginDTO, headers);
        return restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        }catch (Exception e){
            throw new DemoAPIException("API-001:Error while invoking API");
        }
    }

    private UserEntity saveUserEntity(User user) throws DemoDataException {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(user.getUsername());
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userRegistrationRepository.save(userEntity);
            LoginDTO loginDTO = saveLoginDTO(user);
            return userEntity;
        }catch (Exception e){
            throw new DemoDataException("DATA-001:Error while saving user data");
        }

    }

    private User registerEvents(User user) throws DemoDataException{
        try {
        UserRegisteredEvent userRegisteredEvent = new UserRegisteredEvent();
        userRegisteredEvent.setEmail(user.getEmail());
        userRegisteredEvent.setFirstName(user.getFirstName());
        userRegisteredEvent.setLastName(user.getLastName());
        userRegisteredEvent.setEmail(user.getEmail());
        applicationEventPublisher.publishEvent(userRegisteredEvent);
        return user;
        }catch (Exception e){
            throw new DemoEventException("EVENT-001:Error while sending the user data");
        }
    }

    private LoginDTO saveLoginDTO(User user) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(user.getUsername());
        loginDTO.setPassword(user.getPassword());
        loginService.saveLogin(loginDTO);
        return loginDTO;
    }




    public boolean verify(String userName) {
        Optional<UserEntity> userEntity = userRegistrationRepository.findById(userName);
        return userEntity.isPresent();
    }


}
