package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setName("test");

        User user1 = new User("test", "test@test.com");

        User user2 = user.builder()
                .name("test")
                .email("test@test.com")
                .build();
        System.out.println(">>> " + user);
    }

}