package es.uca.iotrestapiexample.books;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController implements BookAPI {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@Override
	public ResponseEntity<BookResponseDTO> addBook(BookRequestDTO body) throws IOException {
		return ResponseEntity.ok(bookService.addBook(body));
	}

	@Override
	public ResponseEntity<List<BookResponseDTO>> getBooks() throws IOException {
		return ResponseEntity.ok(bookService.getBooks());
	}

	@Override
	public ResponseEntity<BookResponseDTO> getBook(Long bookId) throws IOException {
		return ResponseEntity.ok(bookService.getBook(bookId));
	}

	@Override
	public ResponseEntity<BookResponseDTO> postComment(Long bookId, BookCommentRequestDTO bookCommentRequestDTO)
			throws IOException {
		return ResponseEntity.ok(bookService.commentBook(bookId, bookCommentRequestDTO));
	}

	@Override
	public ResponseEntity<Void> deleteBook(Long bookId) throws IOException {
		bookService.removeBook(bookId);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<BookResponseDTO> modifyBook(Long bookId, BookRequestDTO bookRequestDTO) throws IOException {
		return ResponseEntity.ok(bookService.modifyBook(bookId, bookRequestDTO));
	}

}
