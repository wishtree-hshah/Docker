package com.docker.demo;

import com.docker.demo.entity.Book;
import com.docker.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class DockerDemoApplication {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping
	public Book addBook(@RequestBody Book book){
		return bookRepository.save(book);
	}

	@GetMapping
	public List<Book> getBook(){
		return bookRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
	}

}
