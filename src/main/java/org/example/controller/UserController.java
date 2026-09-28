package org.example.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.example.dto.UsersDto;
import org.example.dto.UsersMainDto;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Find all users")
    @GetMapping
    public List<UsersDto> findAll(@RequestParam(required = false) String name){
        return userService.findAll(name);
    }

    @Operation(summary = "Find =by id users")
    @GetMapping("/{id}")
    public UsersDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @Operation(summary = "Create users")
    @PostMapping
    public UsersDto create(@RequestBody UsersMainDto dto){
        return userService.create(dto);
    }

    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    public UsersDto update(@PathVariable Long id,
                            @RequestBody UsersMainDto dto){
        return userService.update(id, dto);
    }

    @Operation(summary = "Delet by id")
    @DeleteMapping("/{id}")
    public UsersDto delete(@PathVariable Long id){
        UsersDto deletedElement = userService.findById(id);
        userService.delete(id);
        return deletedElement;
    }
}
