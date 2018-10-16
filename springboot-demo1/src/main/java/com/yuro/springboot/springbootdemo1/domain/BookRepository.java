package com.yuro.springboot.springbootdemo1.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 接口 继承JpaRepository<实体类， id对应的类>
 *
 */

public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, Integer status);

    List<Book> findByDescriptionEndingWith(String end);
}
