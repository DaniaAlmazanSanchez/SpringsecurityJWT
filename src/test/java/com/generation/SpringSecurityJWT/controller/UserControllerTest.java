package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.Post;
import com.generation.SpringSecurityJWT.model.User;
import com.generation.SpringSecurityJWT.service.PostService;
import com.generation.SpringSecurityJWT.service.UserService;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

class UserControllerTest {
    @Test
    @DisplayName("pruebas post")
    void saveTest(){
        UserService userservice = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder =mock(BCryptPasswordEncoder.class);
        UserController UserController = new UserController(userservice,bCryptPasswordEncoder);

        User user = new User();
        user.setName("DANIA");
        user.setUsername("dania@gmai.com");
        user.setPassword("12345");

        when(userservice.save(any(User.class))).thenReturn(user);

        User result = UserController.saveUser(user);
        verify(userservice, times(1)).save(any(User.class));
        verify(bCryptPasswordEncoder,atLeastOnce()).encode("12345");
        assertEquals(user.getName(),result.getName());
    }
    @Test
    @DisplayName("pruebas en getuser")
    void getUserTest(){
        UserService userservice = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder =mock(BCryptPasswordEncoder.class);
        UserController UserController = new UserController(userservice,bCryptPasswordEncoder);

        User user = new User();
        user.setId(1L);
        user.setName("DANIA");
        user.setUsername("dania@gmai.com");
        user.setPassword("12345");

        when(userservice.getUser(1L)).thenReturn(user);

        User result = UserController.getUser(1L);
        verify(userservice, times(1)).getUser(1L);
        verify(bCryptPasswordEncoder,atLeastOnce()).encode("12345");
        assertEquals(user.getName(),result.getName());
    }


}