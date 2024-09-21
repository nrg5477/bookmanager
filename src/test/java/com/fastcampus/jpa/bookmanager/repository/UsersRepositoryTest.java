package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Users;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
class UsersRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        //List<Users> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        //List<Users> users = userRepository.findAllById((Lists.newArrayList(1L, 3L, 5L)));
        //users.forEach(System.out::println);


//        Users user1 = new Users("jack","jack@dot.com");
//        Users user2 = new Users("holle","holle@dot.com");
//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//        List<Users> users = userRepository.findAll();
//        users.forEach(System.out::println);

        //Users user = userRepository.getOne(1L); //@Transactional 필요
        //System.out.println(user);

        Optional<Users> user = userRepository.findById(1L);
        System.out.println(user);
    }
}
