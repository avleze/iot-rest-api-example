package es.uca.iotrestapiexample.books;

import java.util.List;

public class BookResponseDTO {
	private Long id;
	private String name;
	private String isbn;
	private String editorial;
	private String author;
	private List<BookCommentResponseDTO> comments;

	public BookResponseDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<BookCommentResponseDTO> getComments() {
		return comments;
	}

	public void setComments(List<BookCommentResponseDTO> comments) {
		this.comments = comments;
	}

}
