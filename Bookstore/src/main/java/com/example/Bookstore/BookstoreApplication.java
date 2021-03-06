package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;




@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			crepository.save(new Category("Toiminta"));
			crepository.save(new Category("Klassikot"));
			crepository.save(new Category("Dokkarit"));
			crepository.save(new Category("Historia"));
			crepository.save(new Category("Romanssi"));
			crepository.save(new Category("Tiede"));
			
			
			repository.save(new Book("Jose Junninen", "Josen kirja", 1921, "123-123", crepository.findByName("Klassikot").get(0)));
			repository.save(new Book("Niko Lindgren", "Nikon kirja", 1940, "321-321",  crepository.findByName("Klassikot").get(0)));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}




