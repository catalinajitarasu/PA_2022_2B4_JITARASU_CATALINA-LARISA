package com.example.laborator11.controllers;

import com.example.laborator11.entity.UserEntity;
import com.example.laborator11.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userController")
public class UserController {
    //private final UserEntityService userService;
    private UserEntityRepository userEntityRepository;

    @Autowired
    public UserController(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUserList() {
        return ResponseEntity.ok(userEntityRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @PutMapping("/{name}")
    public UserEntity putUserName(@PathVariable long id, @RequestParam String name) {
        UserEntity user = userEntityRepository.getUserByIdUser(id);
        user.setName(name);
        userEntityRepository.save(user);
        return user;
    }


   @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userEntityRepository.deleteUserByIdUser(id);
    }

    @PostMapping
    public void createPerson(@RequestBody UserEntity user) {
        userEntityRepository.save(user);
    }
}
