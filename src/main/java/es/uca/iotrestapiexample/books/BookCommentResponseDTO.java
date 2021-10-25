package es.uca.iotrestapiexample.books;

public class BookCommentResponseDTO {
	private String author;
	private String comment;
	
	public BookCommentResponseDTO() {
		super();
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
