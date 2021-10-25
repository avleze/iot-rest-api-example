package es.uca.iotrestapiexample.books;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses=BookCommentMapper.class)
public interface BookMapper {
	public List<BookResponseDTO> booksToBooksResponseDTO(Iterable<Book> books);

	public BookResponseDTO bookToBookResponseDTO(Book book);

	public Book bookRequestDTOToBook(BookRequestDTO book);
}
