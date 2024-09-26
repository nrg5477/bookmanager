package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

class UsersTest {
    @Test
    void test() {
        Users users = new Users();
        users.setEmail("test@test.com");
        users.setName("test");

        Users users1 = new Users("test", "test@test.com");

        Users users2 = users.builder()
                .name("test")
                .email("test@test.com")
                .build();
        System.out.println(">>> " + users);
//
    }

}