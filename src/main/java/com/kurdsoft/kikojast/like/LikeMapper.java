package com.kurdsoft.kikojast.like;


import com.kurdsoft.kikojast.place.PlaceMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PlaceMapper.class})
public interface LikeMapper {

    Like toLike(LikeDTO likeDTO);
    LikeDTO toLikeDTO(Like like);

    List<Like> tolikes(List<LikeDTO> dtoList);
    List<LikeDTO> LikeDTOs(List<Like> likes);

}
