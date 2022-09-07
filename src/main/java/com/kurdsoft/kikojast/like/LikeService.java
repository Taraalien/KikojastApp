package com.kurdsoft.kikojast.like;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class LikeService implements ILikeService {
    private final LikeRep rep;


    @Override
    public Like save(Like like) {
        return rep.save(like);
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Like getById(Long id) {

        Optional<Like> optionalLike = rep.findById(id);
        if (!optionalLike.isPresent()) {
            throw new NotFoundException("Not found ");
        }
        return optionalLike.get();
    }

    @Override
    public List<Like> getAll() {
        return (List<Like>) rep.findAll();
    }

    @Override
    public List<Like> getByUserId(Long userId) {
        return rep.findAllByUserId(userId);
    }

    @Override
    public List<Like> getByPlaceId(Long placeId) {
        return rep.findAllByPlaceId(placeId);
    }
}
