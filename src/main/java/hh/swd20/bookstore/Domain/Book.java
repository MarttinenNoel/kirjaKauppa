package hh.swd20.bookstore.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String year;
	private String isbn;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Book(String title, String author, String year, String isbn, Double price, Category category) {
		super();
		this.setTitle(title);
		this.setAuthor(author);
		this.setYear(year);
		this.setIsbn(isbn);
		this.setPrice(price);
		this.category = category;
	}
	public Book() {
		super();
		setTitle("Unknown");
		setAuthor("Unknown");
		setYear("Unknown");
		setIsbn("Unknown");
		setPrice(0.00);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "title =" + title + ", author=" + author;
	}
}


