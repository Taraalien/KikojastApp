package com.kurdsoft.kikojast.comment;


import com.kurdsoft.kikojast.like.Like;
import com.kurdsoft.kikojast.like.LikeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/commentV1/")
public class CommentController {

    private final  ICommentService service;
    private  CommentMapper mapper;


    @PostMapping("/commentV1")
    public ResponseEntity save(@RequestBody CommentDTO commentDTO){
        Comment comment=mapper.toComment(commentDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/commentV1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/commentV1/{id}")
    public ResponseEntity<CommentDTO>getById(@PathVariable Long id){
        Comment comment=service.getById(id);
        CommentDTO commentDto=mapper.toCommentDto(comment);
        return ResponseEntity.ok(commentDto);
    }

    @GetMapping("/commentV1")
    public ResponseEntity<List<CommentDTO>> getAll(){

        List<Comment> comments=service.getAll();
        List<CommentDTO> commentDTOS=mapper.toCommentDTOS(comments);
        return ResponseEntity.ok(commentDTOS);
    }


    @GetMapping("/commentV1/{userId}")
    public ResponseEntity<List<CommentDTO>> getByUserId(@PathVariable Long id){
        List<Comment> comments=service.getByUserId(id);
        List<CommentDTO> commentDTOS=mapper.toCommentDTOS(comments);
        return ResponseEntity.ok(commentDTOS);
    }

    @GetMapping("/commentV1/{placeId}")
    public ResponseEntity<List<CommentDTO>> getByPlaceId(@PathVariable Long id){
        List<Comment> commentList=service.getByPlaceId(id);
        List<CommentDTO> commentDTOS=mapper.toCommentDTOS(commentList);
        return ResponseEntity.ok(commentDTOS);
    }

}
