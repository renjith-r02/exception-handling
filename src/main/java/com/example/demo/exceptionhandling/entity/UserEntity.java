package com.example.demo.exceptionhandling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder*/
 public class UserEntity {
    @Id
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}