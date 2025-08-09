package ru.gl.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gl.security.dto.UserDto;
import ru.gl.security.entity.User;
import ru.gl.security.repository.UserRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(user.getUsername(), user.getRole()))
                .toList();
    }
}
