package com.unloadbrain;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


public class JWTUtilsTest {

    @Test
    public void shouldReturnValidNotNullToken() {

        JWTUtils jwtUtils = new JWTUtils();

        String token = jwtUtils.createJwtToken(Collections.singletonMap("name", "roni"));
        System.out.println(token);

        assertNotNull(token);
    }


    @Test
    public void shouldReturnFalseForInvalidToken() {

        JWTUtils jwtUtils = new JWTUtils();

        boolean tokenValid = jwtUtils.isValidJwtToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoicm9uaSIsImV4cCI6MTU4NzU3NTU2MH0.jHP7cx-Wnsocwu9lyQF7rjEteNGxqze75rOxwkqOVqU");
        assertFalse(tokenValid);
    }
}
