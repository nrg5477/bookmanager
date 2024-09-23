package com.fastcampus.jpa.bookmanager.repository;


import com.fastcampus.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {//entity 타입, pk 타입.

    List<Users> findByName(String name);

    Users findByEmail(String email);

    Users getByEmail(String email);

    Users readByEmail(String email);

    Users queryByEmail(String email);

    Users searchByEmail(String email);

    Users streamByEmail(String email);

    Users findUsersByEmail(String email);

    List<Users> findFirstByName(String name);
    List<Users> findTop1ByName(String name);

    List<Users> findByEmailAndName(String email, String name);

    List<Users> findByEmailOrName(String email, String name);

    List<Users> findByCreatedAtAfter(LocalDateTime yesterday);//꼭 시간만 가능한가?
    List<Users> findByIdAfter(Long id);//No! 다른것도 가능! 허나 주로 날짜와 사긴에만 주로 사용한다.

    List<Users> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<Users> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
    List<Users> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<Users> findByIdBetween(Long id1, Long id2);
}
