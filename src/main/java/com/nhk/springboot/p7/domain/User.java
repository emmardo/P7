package com.nhk.springboot.p7.domain;

import com.nhk.springboot.p7.services.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Password is mandatory")
    @ValidPassword
    private String password;
    @NotBlank(message = "Full Name is mandatory")
    private String fullName;
    @NotBlank(message = "Role is mandatory")
    private String role;

    public User(String username,String password,String fullName,String role) {

        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
