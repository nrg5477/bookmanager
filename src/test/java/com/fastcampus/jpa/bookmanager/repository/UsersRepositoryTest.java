package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.Users;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.EndsWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

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

//        Optional<Users> user = userRepository.findById(1L);
//        System.out.println(user);

//        userRepository.save(new Users("new nrg5477","newnrg5477@gmail.com"));
//        userRepository.flush();
//        userRepository.findAll().forEach(System.out::println);

//        long count = userRepository.count();
//        System.out.println(count);

//        boolean exists = userRepository.existsById(1L);
//        System.out.println(exists);

//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));

//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.findAll().forEach(System.out::println);

//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.findAll().forEach(System.out::println);

//        userRepository.deleteAllInBatch();
//        userRepository.findAll().forEach(System.out::println);

        //일반 delete문은 select문을 통해서 있는지 확인하고 지우지만,
        //delete batch 문은 바로 지워버림.

//        //Paging
//        Page<Users> users = userRepository.findAll(PageRequest.of(1, 3)); //pagerequest는 pagealbe의 구현체
//        System.out.println("page : " + users);
//        System.out.println("total elements : " + users.getTotalElements());
//        System.out.println("total pages : " + users.getTotalPages());
//        System.out.println("number of elements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//        users.getContent().forEach(System.out::println);

//        //Query By Example
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//
//        Example<Users> example = Example.of(new Users("nr", "gmail.com"), matcher);
//        userRepository.findAll(example).forEach(System.out::println);
//
//        //-------------------------또다른 방법
//        Users user = new Users();
//        user.setEmail("naver");
//
//        ExampleMatcher matcher2 = ExampleMatcher.matching().withMatcher("email", contains());
//        Example<Users> example2 = Example.of(user, matcher2);
//
//        userRepository.findAll(example2).forEach(System.out::println);

        userRepository.save(new Users("david","david@gmail.com"));

        Users user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("nrg5477-updated@gmail.com");
        userRepository.save(user);

    }

    @Test
    void select() {
        System.out.println(userRepository.findByName("nrg5477"));

        System.out.println("findByEmail : " + userRepository.findByEmail("nrg5477@gmail.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("nrg5477@gmail.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("nrg5477@gmail.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("nrg5477@gmail.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("nrg5477@gmail.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("nrg5477@gmail.com"));
        System.out.println("findUsersByEmail : " + userRepository.findUsersByEmail("nrg5477@gmail.com"));

        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("nrg5477"));
        System.out.println("findFirstByName : " + userRepository.findFirstByName("nrg5477"));

        System.out.println("findByEmailAndName : "+userRepository.findByEmailAndName("nrg5477@gmail.com", "nrg5477"));
        System.out.println("findByEmailOrName : "+userRepository.findByEmailOrName("nrg5477@gmail.com", "nrg4577"));

        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
        System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty()); //collection type의 notEmpty 확인


        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("nrg5477", "nrg4577")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("nrg"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("477"));
        System.out.println("findByNameContaining : " + userRepository.findByNameContaining("g54"));

        System.out.println("findByNameLike: " + userRepository.findByNameLike("%g54%"));


    }

    @Test
    void pagingAndSortingTest() {
        //SortingTest
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("nrg5477"));
        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("nrg5477"));//last1이라는게 없어서 이름으로 사용됨.

        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("nrg5477"));
        //해당 방식은 이름이 길어져서 가독성이 낮음
        System.out.println("findFirstByName : " + userRepository.findFirstByName("nrg5477", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        //가독성을 높이기 위해 하나의 메소드로 Sort방식을 확장하여 사용함. 이방식이 메리트가 높음


        //PagingTest
        System.out.println("findByName : " + userRepository.findByName("nrg5477", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());


    }

    @Test
    void insertAndUpdateTest() {
        Users user = new Users();
        user.setName("nrg5477");
        user.setEmail("nrg5477@gmail.com");

        userRepository.save(user);

        Users user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("nrrrrrrrrg5477");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        Users user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);
        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest() {
        Users user = new Users();
        user.setEmail("nrg54772@gmail.com");
        user.setName("nrg54772");

        userRepository.save(user);

        Users user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("nrggggggg5477");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest() {
        Users user = new Users();
        user.setEmail("nrg54772@gmail.com");
        user.setName("nrg54772");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("nrg54772@gmail.com"));
    }

    @Test
    void updateTest() {
        Users user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("nrg54772");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }
}

