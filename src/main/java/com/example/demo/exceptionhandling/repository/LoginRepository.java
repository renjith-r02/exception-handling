package com.example.demo.exceptionhandling.repository;

import com.example.demo.exceptionhandling.entity.LoginEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginEntity,String> {
}
