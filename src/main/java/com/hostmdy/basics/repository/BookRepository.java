package com.hostmdy.basics.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.basics.entity.Book;

public interface BookRepository extends CrudRepository<Book,Long>{

}
