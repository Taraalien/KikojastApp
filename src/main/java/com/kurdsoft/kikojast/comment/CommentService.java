package com.kurdsoft.kikojast.comment;


import com.kurdsoft.kikojast.like.Like;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class CommentService implements ICommentService {

    private final CommentRep rep;


    @Override
    public Comment save(Comment comment) {
        return rep.save(comment);
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Comment getById(Long id) {
        Optional<Comment> optionalComment=rep.findById(id);
        if(!optionalComment.isPresent()){
            throw  new NotFoundException("Not Found");
        }
        return optionalComment.get();
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>)rep.findAll();
    }

    @Override
    public List<Comment> getByUserId(Long userId) {
        return rep.findAllByUserId(userId);
    }

    @Override
    public List<Comment> getByPlaceId(Long placeId) {
        return rep.findAllByPlaceId(placeId);
    }
}
