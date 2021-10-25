package es.uca.iotrestapiexample.books;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "bookAPI")
public interface BookAPI {
	@ApiOperation(value = "Adds a book", nickname = "addBook", notes = "Adds a new book")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Book created"),
			@ApiResponse(code = 400, message = "invalid input, object invalid"), })
	@PostMapping(value = "books/", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = "application/json")
	public ResponseEntity<BookResponseDTO> addBook(@RequestBody BookRequestDTO body) throws IOException;

	@ApiOperation(value = "Get all books", nickname = "getBooks", notes = "Get all books")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Get all books success") })
	@GetMapping(value = "books/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<BookResponseDTO>> getBooks() throws IOException;

	@ApiOperation(value = "Get a book", nickname = "getBook", notes = "Get a book")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Get a books success") })
	@GetMapping(value = "books/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<BookResponseDTO> getBook(@PathVariable("bookId") Long bookId) throws IOException;

	@ApiOperation(value = "Comment a book", nickname = "commentBook", notes = "Comment a book")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Book commented"),
			@ApiResponse(code = 400, message = "invalid input, object invalid") })
	@PostMapping(value = "books/{bookId}/comments", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = "application/json")
	public ResponseEntity<BookResponseDTO> postComment(@PathVariable("bookId") Long bookId,
			@RequestBody BookCommentRequestDTO bookCommentRequestDTO) throws IOException;

	@ApiOperation(value = "Delete a book", nickname = "deleteBook", notes = "Delete a book")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Book deleted") })
	@DeleteMapping(value = "books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId) throws IOException;

	@ApiOperation(value = "Modify a book", nickname = "modifyBook", notes = "Modify a book")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Book commented"),
			@ApiResponse(code = 400, message = "invalid input, object invalid"), })
	@PutMapping(value = "books/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = "application/json")
	public ResponseEntity<BookResponseDTO> modifyBook(@PathVariable("bookId") Long bookId,
			@RequestBody BookRequestDTO bookRequestDTO) throws IOException;
}
