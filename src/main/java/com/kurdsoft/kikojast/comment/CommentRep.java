package com.kurdsoft.kikojast.comment;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRep extends PagingAndSortingRepository<Comment,Long> {

    List<Comment> findAllByUserId(Long userId);
    List<Comment> findAllByPlaceId(Long placeId);
}
