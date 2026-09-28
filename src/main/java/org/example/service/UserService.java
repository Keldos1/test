package org.example.service;

import org.apache.catalina.User;
import org.example.dto.UsersDto;
import org.example.dto.UsersMainDto;
import org.example.entity.Users;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UsersDto> findAll(String name) {
        List<Users> users;
        if (name == null) {
            users = userRepository.findAll();
        } else {
            users = userRepository.findByUserName(name).stream().toList();
        }
        return users.stream().map(
                user -> new UsersDto(user.getId(),
                        user.getUserName())).toList();
    }

    @Transactional(readOnly = true)
    public UsersDto findById(Long id) {
        Users user = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
        return new UsersDto(user.getId(), user.getUserName());
    }

    @Transactional
    public UsersDto create(UsersMainDto dto) {
        Users user = new Users();
        user.setId(dto.id());
        user.setUserName(dto.name());
        Users result = userRepository.save(user);
        return new UsersDto(result.getId(), result.getUserName());
    }

    @Transactional
    public UsersDto update(Long id, UsersMainDto dto) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setId(dto.id());
        user.setUserName(dto.name());
        Users result = userRepository.save(user);
        return new UsersDto(result.getId(),
                result.getUserName());
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);

    }
}
