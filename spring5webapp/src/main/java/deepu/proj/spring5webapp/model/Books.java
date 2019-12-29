package deepu.proj.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bid;
	private String title;
	private String isbn;
	private String publisher;
	@ManyToMany
	@JoinTable(name="author_books",joinColumns = @JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> author = new HashSet<>();
	
	
	/**
	 * 
	 */
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param title
	 * @param isbn
	 * @param publisher
	 */
	public Books(Long bid,String title, String isbn, String publisher) {

		this.bid = bid;
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	/**
	 * @param bid
	 * @param title
	 * @param isbn
	 * @param publisher
	 * @param author
	 */
	public Books(Long bid, String title, String isbn, String publisher, Set<Author> author) {
		this.bid = bid;
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Set<Author> getAuthor() {
		return author;
	}
	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Books [bid=" + bid + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + ", author="
				+ author + "]";
	}
	
	

}
