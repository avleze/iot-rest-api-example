package es.uca.iotrestapiexample.books;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookCommentMapper {
	public List<BookCommentResponseDTO> bookCommentsToBookCommentsResponseDTO(List<BookComment> bookComments);
}
