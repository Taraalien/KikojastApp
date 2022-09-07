package com.kurdsoft.kikojast.comment;


import com.kurdsoft.kikojast.place.Place;
import com.kurdsoft.kikojast.place.PlaceMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PlaceMapper.class})
public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);
    List<Comment> toComments(List<CommentDTO> dtoList);

    CommentDTO toCommentDto(Comment comment);
    List<CommentDTO> toCommentDTOS(List<Comment> comments);

}
