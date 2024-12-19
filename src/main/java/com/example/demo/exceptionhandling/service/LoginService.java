package com.example.demo.exceptionhandling.service;

import com.example.demo.exceptionhandling.model.LoginDTO;
import com.example.demo.exceptionhandling.entity.LoginEntity;
import com.example.demo.exceptionhandling.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class LoginService {


    LoginRepository loginRepository;
   // RestTemplate restTemplate ;

    LoginService(@Autowired LoginRepository loginRepository){//, @Autowired RestTemplate restTemplate) {
            this.loginRepository = loginRepository;
          //  this.restTemplate = restTemplate;
    }

    public void saveLogin( LoginDTO loginDTO1) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUsername(loginDTO1.getUsername());
        loginEntity.setPassword(loginDTO1.getPassword());
        loginRepository.save(loginEntity);

    }

    public boolean login(LoginDTO loginDTO) {

        Optional<LoginEntity> loginEntity = loginRepository.findById(loginDTO.getUsername());
        if (loginEntity.isPresent()) {
            LoginEntity loginEntity1 = loginEntity.get();
            return loginEntity1.getPassword().equals(loginDTO.getPassword());
        }

        return false;
    }
}
