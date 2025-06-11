package ru.smrdela.backend.service;

import ru.smrdela.backend.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
}
