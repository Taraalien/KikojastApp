package com.kurdsoft.kikojast.like;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like/")
@AllArgsConstructor
public class LikeController {

    private final ILikeService service;
    private LikeMapper mapper;


    @PostMapping("/likeV1")
    public ResponseEntity save(@RequestBody LikeDTO dto){
        Like like=mapper.toLike(dto);
        service.save(like);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/likeV1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/likeV1/{id}")
    public ResponseEntity<LikeDTO>getById(@PathVariable Long id){
        Like like=service.getById(id);
        LikeDTO likeDTO=mapper.toLikeDTO(like);
        return ResponseEntity.ok(likeDTO);
    }

    @GetMapping("/likeV1")
    public ResponseEntity<List<LikeDTO>> getAll(){

        List<Like> likes=service.getAll();
        List<LikeDTO> likeDTOS=mapper.LikeDTOs(likes);
        return ResponseEntity.ok(likeDTOS);
    }


    @GetMapping("/likeV1/{userId}")
    public ResponseEntity<List<LikeDTO>> getByUserId(@PathVariable Long id){
        List<Like> likeList=service.getByUserId(id);
        List<LikeDTO> likeDTOS=mapper.LikeDTOs(likeList);
        return ResponseEntity.ok(likeDTOS);
    }

    @GetMapping("/likeV1/{placeId}")
    public ResponseEntity<List<LikeDTO>> getByPlaceId(@PathVariable Long id){
        List<Like> likeList=service.getByPlaceId(id);
        List<LikeDTO> likeDTOS=mapper.LikeDTOs(likeList);
        return ResponseEntity.ok(likeDTOS);
    }


}
