package com.m4ricu.single.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.m4ricu.single.model.User;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void testFindByUsername() {
        User user = new User();
        user.setUsername("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));

        Optional<User> foundUser = userRepository.findByUsername("testuser");

        assertTrue(foundUser.isPresent());
        assertEquals("testuser", foundUser.get().getUsername());
    }

    @Test
    void testFindByCpf() {
        User user = new User();
        user.setCpf("123.456.789-00");
        when(userRepository.findByCpf("123.456.789-00")).thenReturn(Optional.of(user));

        Optional<User> foundUser = userRepository.findByCpf("123.456.789-00");

        assertTrue(foundUser.isPresent());
        assertEquals("123.456.789-00", foundUser.get().getCpf());
    }

    @Test
    void testFindByUsername_NotFound() {

        when(userRepository.findByUsername("notfounduser")).thenReturn(Optional.empty());

        Optional<User> notFoundUser = userRepository.findByUsername("notfounduser");

        assertTrue(notFoundUser.isEmpty());

    }

    @Test
    void testFindByCpf_NotFound() {

        when(userRepository.findByCpf("000.000.000-00")).thenReturn(Optional.empty());

        Optional<User> notFoundUser = userRepository.findByCpf("000.000.000-00");

        assertTrue(notFoundUser.isEmpty());

    }
}
