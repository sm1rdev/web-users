package ru.smrdela.backend.repository;

import ru.smrdela.backend.models.User;

import java.util.List;

public interface UserRepository {
    public List<User> getUsers();
}
