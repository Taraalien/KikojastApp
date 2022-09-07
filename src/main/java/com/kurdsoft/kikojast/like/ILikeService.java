package com.kurdsoft.kikojast.like;


import java.util.List;

public interface ILikeService {

    Like save(Like like);
    void delete(Long id);
    Like getById(Long id);
    List<Like> getAll();
    List<Like> getByUserId(Long userId);
    List<Like> getByPlaceId(Long placeId);
}
