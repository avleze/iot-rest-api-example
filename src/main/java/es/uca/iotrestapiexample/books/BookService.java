package es.uca.iotrestapiexample.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	private BookRepository bookRepository;
	private BookCommentRepository bookCommentRepository;
	private BookMapper bookMapper;

	@Autowired
	public BookService(BookRepository bookRepository, BookCommentRepository bookCommentRepository, BookMapper bookMapper) {
		this.bookRepository = bookRepository;
		this.bookCommentRepository = bookCommentRepository;
		this.bookMapper = bookMapper;
	}

	public List<BookResponseDTO> getBooks() {
		return bookMapper.booksToBooksResponseDTO(this.bookRepository.findAll());
	}

	public BookResponseDTO getBook(Long id) {
		return bookMapper.bookToBookResponseDTO(this.bookRepository.findById(id).get());
	}

	public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) {
		Book bookToSave = this.bookMapper.bookRequestDTOToBook(bookRequestDTO);
		Book savedBook = this.bookRepository.save(bookToSave);
		return this.bookMapper.bookToBookResponseDTO(savedBook);
	}

	public BookResponseDTO commentBook(Long id, BookCommentRequestDTO bookCommmentRequestDTO) {
		Book book = this.bookRepository.findById(id).get();
		BookComment newComment = new BookComment();
		newComment.setAuthor(bookCommmentRequestDTO.getAuthor());
		newComment.setComment(bookCommmentRequestDTO.getComment());
		BookComment savedComment = this.bookCommentRepository.save(newComment);
		book.postComment(savedComment);
		Book savedBook = this.bookRepository.save(book);
		return this.bookMapper.bookToBookResponseDTO(savedBook);
	}

	public BookResponseDTO modifyBook(Long id, BookRequestDTO bookRequestDTO) {
		Book book = this.bookRepository.findById(id).get();
		book.setAuthor(bookRequestDTO.getAuthor());
		book.setEditorial(bookRequestDTO.getEditorial());
		book.setIsbn(bookRequestDTO.getIsbn());
		book.setName(bookRequestDTO.getName());
		return this.bookMapper.bookToBookResponseDTO(this.bookRepository.save(book));
	}

	public void removeBook(Long id) {
		this.bookRepository.deleteById(id);
	}
}
