package com.taskify.service;

import com.taskify.dto.UserRequest;
import com.taskify.dto.UserUpdateRequest;
import com.taskify.entity.User;
import com.taskify.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User addUser(UserRequest userRequest) {
        User byEmail =  userRepository.findByEmail(userRequest.getEmail());
        if(Objects.isNull(byEmail)) {
            User user = User.builder()
                    .name(userRequest.name)
                    .email(userRequest.email)
                    .password(userRequest.password)
                    .build();
            byEmail = userRepository.save(user);
        }
        return byEmail;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userUpdateRequest.getName());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}