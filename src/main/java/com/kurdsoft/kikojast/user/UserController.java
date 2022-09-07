package com.kurdsoft.kikojast.user;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user/")
public class UserController {
    private final IUserService service;
    private UserMapper mapper;


    @PostMapping("/userV1")
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        User user=mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/userV1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/userV1/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        User user=service.getById(id);
        UserDTO userDTO=mapper.toUserDto(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/userV1/")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<User> users=service.getAll();
        List<UserDTO> userDTOS=mapper.toUserDTOS(users);
        return ResponseEntity.ok(userDTOS);

    }

}
