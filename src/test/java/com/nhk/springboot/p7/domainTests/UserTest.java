package com.nhk.springboot.p7.domainTests;

import com.nhk.springboot.p7.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private Integer id = 1;
    private String username = "";
    private String password = "";
    private String fullName = "";
    private String role = "";

    @Test
    public void parameterisedConstructor() {

        //Act
        User newUser = new User(username, password, fullName, role);

        //Assert
        assertEquals(username, newUser.getUsername());
        assertEquals(password, newUser.getPassword());
        assertEquals(fullName, newUser.getFullName());
        assertEquals(role, newUser.getRole());
    }

    @Test
    public void setId() {

        //Arrange
        User newUser = new User();

        //Act
        newUser.setId(id);

        //Assert
        assertEquals(id, newUser.getId());
    }

    @Test
    public void setUsername() {

        //Arrange
        User newUser = new User();

        //Act
        newUser.setUsername(username);

        //Assert
        assertEquals(username, newUser.getUsername());
    }

    @Test
    public void setPassword() {

        //Arrange
        User newUser = new User();

        //Act
        newUser.setPassword(password);

        //Assert
        assertEquals(password, newUser.getPassword());
    }

    @Test
    public void setFullName() {

        //Arrange
        User newUser = new User();

        //Act
        newUser.setFullName(fullName);

        //Assert
        assertEquals(fullName, newUser.getFullName());
    }

    @Test
    public void setRole() {

        //Arrange
        User newUser = new User();

        //Act
        newUser.setRole(role);

        //Assert
        assertEquals(role, newUser.getRole());
    }
}
