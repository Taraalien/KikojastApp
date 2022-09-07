package com.kurdsoft.kikojast.comment;


import com.kurdsoft.kikojast.like.Like;

import java.util.List;

public interface ICommentService {

    Comment save(Comment comment);
    void delete(Long id);
    Comment getById(Long id);
    List<Comment> getAll();
    List<Comment> getByUserId(Long userId);
    List<Comment> getByPlaceId(Long placeId);

}
