package com.fastcampus.jpa.bookmanager.repository;


import com.fastcampus.jpa.bookmanager.domain.Users;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    List<Users> findByIdIsNotNull();

    List<Users> findByAddressIsNotEmpty();

    List<Users> findByNameIn(List<String> names);

    List<Users> findByNameStartingWith(String name);
    List<Users> findByNameEndingWith(String name);
    List<Users> findByNameContaining(String name);

    List<Users> findByNameLike(String name);

    List<Users> findUsersByNameIs(String name);
    List<Users> findUsersByName(String name);
    List<Users> findUsersByNameEquals(String name);

    //쿼리 메소드로 정렬 시켜보기
    List<Users> findLast1ByName(String name);
    List<Users> findTop1ByNameOrderByIdDesc(String name);
    List<Users> findFirstByNameOrderByIdDescEmailAsc(String name); //두번째 조건으로 추가 정렬(같은것이 있을때)

    List<Users> findFirstByName(String name, Sort sort);

    //쿼리메소드로 페이징 처리하기.
    Page<Users> findByName(String name, Pageable pageable);

    @Query(value = "select * from users limit 1;", nativeQuery = true)
    Map<String, Object> findRawRecord();
    //

}
