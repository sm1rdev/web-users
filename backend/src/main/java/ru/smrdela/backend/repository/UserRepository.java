package ru.smrdela.backend.repository;

import ru.smrdela.backend.models.User;

import java.util.List;

public interface UserRepository {
    public List<User> getUsers();
    public User getUserById(int id);
    public void createUser(User user);
    public void updateUser(int id, User user);
    public void deleteUserById(int id);
}
