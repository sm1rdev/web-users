package ru.smrdela.backend.service;

import ru.smrdela.backend.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(int id);
    public void createUser(User user);
    public void updateUser(int id, User user);
    public void deleteUser(int id);
}
