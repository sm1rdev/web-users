package ru.smrdela.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.smrdela.backend.models.User;
import ru.smrdela.backend.repository.UserRepository;
import ru.smrdela.backend.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User getUser(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public void updateUser(int id, User user) {
        userRepository.updateUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUserById(id);
    }
}
