package com.m4ricu.single.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.m4ricu.single.model.Login;
import com.m4ricu.single.model.User;
import com.m4ricu.single.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser_success() {
        User user = new User();
        user.setCpf("123.456.789-00");
        user.setUsername("testuser");
        user.setPassword("password");

        when(userRepository.findByCpf(user.getCpf())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User registeredUser = userService.registerUser(user);

        assertNotNull(registeredUser);
        assertEquals("encodedPassword", registeredUser.getPassword());
        verify(userRepository).save(user);
    }

    @Test
    public void testRegisterUser_cpfAlreadyExists() {
        User user = new User();
        user.setCpf("123.456.789-00");

        when(userRepository.findByCpf(user.getCpf())).thenReturn(Optional.of(new User()));

        User loggedInUser = userService.registerUser(user);
        assertEquals(loggedInUser, null);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void testLoginUser_success() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("encodedPassword");
        Login login = new Login();
        login.setUsername("testuser");
        login.setPassword("password");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));

        User loggedInUser = userService.loginUser(login);

        assertEquals(user, loggedInUser);
    }

    @Test
    public void testLoginUser_invalidLogin() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("encodedPassword");

        Login wrongLogin = new Login();
        wrongLogin.setUsername("testuser");
        wrongLogin.setPassword("wrongPassword");
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));

        User loggedInUser = userService.loginUser(wrongLogin);
        assertEquals(loggedInUser, null);
    }

}
