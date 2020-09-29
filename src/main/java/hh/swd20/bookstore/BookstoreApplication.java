package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.Domain.Book;
import hh.swd20.bookstore.Domain.BookRepository;
import hh.swd20.bookstore.Domain.Category;
import hh.swd20.bookstore.Domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Tallennetaan kirjoja");
			
			crepository.save(new Category("Realism"));
			crepository.save(new Category("Political Satire"));
			
			brepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "1929", "1232323-21", 0.00, crepository.findByName("Realism").get(0)));
			brepository.save(new Book("Animal Farm", "George Orwell", "1945", "2212343-5", 0.01, crepository.findByName("Political Satire").get(0)));
			
			log.info("Haetaan kirjat");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
