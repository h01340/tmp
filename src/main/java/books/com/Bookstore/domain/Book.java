package books.com.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	 @NotEmpty(message = "Title cannot be empty")
	@Size(min = 3, max = 150)
	private String title;
	private String author;
	private Integer publicationYear;
	private Integer price;
	private long insb;
	
	
	//linking to category 
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	// DATABASE TESTING
	public Book() {}
	
	public Book(@NotEmpty(message = "Book's title cannot be empty") @Size(min = 3, max = 250)String title, String author, Integer publicationYear, long insb, Integer price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.insb = insb;
		this.price = price;
		this.category = category;
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
	public Integer getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	public long getInsb() {
		return insb;
	}
	public void setInsb(long insb) {
		this.insb = insb;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
		return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", insb=" + insb
				+ ", price=" + price + "]";
	}
	
}
