package com.hostmdy.basics.data;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hostmdy.basics.entity.Author;
import com.hostmdy.basics.entity.Book;
import com.hostmdy.basics.repository.AuthorRepository;
import com.hostmdy.basics.repository.BookRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;//PlaceHolder
	private BookRepository bookRepository;
			
	
	public InitialDataLoader(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initialize();
	}

	private void initialize() {
		Book book1 = new Book("Domain Driven Design", "programming", 34.0);
		Author author1 = new Author("Eris", "Evan", "eris@gmail.com");
		//ManyToMany Connect
		book1.getAuthors().add(author1);
		author1.getBooks().add(book1);
		authorRepository.save(author1);//saved first inverse entity
		bookRepository.save(book1);
		
		
		Book book2 = new Book("Java 8 in Action", "programming", 54.0);
		Author author2 = new Author("Jhon", "Doe", "doe@gmail.com");
		//ManyToMany Connect
		book2.getAuthors().add(author2);
		author2.getBooks().add(book2);
		authorRepository.save(author2);//saved first inverse entity
		bookRepository.save(book2);
		
		
		Book book3 = new Book("Effective Java", "programming", 20.0);
		Author author3 = new Author("Jhon", "Smith", "smith@gmail.com");
		//ManyToMany Connect
		book3.getAuthors().add(author3);
		author3.getBooks().add(book3);
		authorRepository.save(author3);//saved first inverse entity
		bookRepository.save(book3);
		
	}

}
