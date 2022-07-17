package com.wipro.DoConnect.entities;

import javax.persistence.*;

import com.wipro.DoConnect.dto.UserDto;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto mapAdmintoUserDto() {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setEmail(email);
        userDto.setName(name);

        return userDto;
    }
}
