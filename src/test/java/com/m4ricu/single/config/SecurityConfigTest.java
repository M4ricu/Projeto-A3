package com.m4ricu.single.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

class SecurityConfigTest {
    private final CorsConfigurationSource corsConfigurationSource = Mockito.mock(CorsConfigurationSource.class);

    private final SecurityConfig securityConfig;

    SecurityConfigTest() {
        this.securityConfig = new SecurityConfig(corsConfigurationSource);
    }

    @Test
    void testFilterChain() throws Exception {
        HttpSecurity httpSecurityMock = mock(HttpSecurity.class);
        when(httpSecurityMock.cors(any())).thenReturn(httpSecurityMock);
        when(httpSecurityMock.authorizeHttpRequests(any())).thenReturn(httpSecurityMock);
        when(httpSecurityMock.build()).thenReturn(mock(DefaultSecurityFilterChain.class));

        securityConfig.filterChain(httpSecurityMock);

        verify(httpSecurityMock).cors(any());
        verify(httpSecurityMock).authorizeHttpRequests(any());
    }

    @Test
    void testCorsConfigurationSource() {
        CorsConfigurationSource result = securityConfig.corsConfigurationSource();
        assertNotNull(result);
    }

}
