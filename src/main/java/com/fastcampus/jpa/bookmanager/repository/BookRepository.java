package com.fastcampus.jpa.bookmanager.repository;


import com.fastcampus.jpa.bookmanager.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;


public interface BookRepository extends JpaRepository<Books, Long> {
}
