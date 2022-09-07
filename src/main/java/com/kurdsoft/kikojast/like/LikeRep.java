package com.kurdsoft.kikojast.like;


import com.kurdsoft.kikojast.place.Place;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LikeRep extends PagingAndSortingRepository<Like,Long> {

  List<Like> findAllByUserId(Long userId);

  List<Like>  findAllByPlaceId(Long placeId);



}
