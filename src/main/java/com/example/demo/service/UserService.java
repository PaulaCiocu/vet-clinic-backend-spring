package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.entity.UserDTO;
import com.example.demo.repository.UserJpaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @PostConstruct
    public void init() {
        User user1 = new User("John", "password123");
        User user2 = new User("Jane", "password456");
        userJpaRepository.save(user1);
        userJpaRepository.save(user2);
    }

    public List<User> getUser() {
        return userJpaRepository.findAll();
    }

    public User getUserById(Long id) {
        return userJpaRepository.findById(id).get();
    }

    @Transactional
    public Long createUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getPassword());
        userJpaRepository.save(user);
        return user.getId();
    }

    @Transactional
    public Long updateUser(UserDTO userDTO) {
        User user = userJpaRepository.findById(userDTO.getId()).get();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        userJpaRepository.save(user);
        return user.getId();
    }
}
