package com.example.Assignment_A1;


import com.example.Assignment_A1.model.Role;
import com.example.Assignment_A1.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class PasswordEncryptionTests {

    @Test
    void testPasswordEncryption(){

        String password = "123456ABCDEF";
        User user = new User("user1",password, Role.CASHIER);
        user.setPassword(user.encryptedPassword(user.getPassword()));
        assertNotEquals(password,user.getPassword());

    }
}
