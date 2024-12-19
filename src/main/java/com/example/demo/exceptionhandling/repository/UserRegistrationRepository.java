package com.example.demo.exceptionhandling.repository;

import com.example.demo.exceptionhandling.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface UserRegistrationRepository extends CrudRepository<UserEntity, String> {
}