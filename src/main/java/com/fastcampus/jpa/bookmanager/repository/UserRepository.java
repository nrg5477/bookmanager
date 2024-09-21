package com.fastcampus.jpa.bookmanager.repository;


import com.fastcampus.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {//entity 타입, pk 타입.

}
