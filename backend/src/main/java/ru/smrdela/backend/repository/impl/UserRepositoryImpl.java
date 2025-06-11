package ru.smrdela.backend.repository.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.smrdela.backend.mapper.UserMapper;
import ru.smrdela.backend.models.User;
import ru.smrdela.backend.repository.UserRepository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String GET_ALL_USERS = "SELECT * FROM users";
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = :id";
    private static final String CREATE_USER = "INSERT INTO users (name, email) VALUES (:name, :email)";
    private static final String UPDATE_USER = "UPDATE users SET name = :name, email = :email WHERE id = :id";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = :id";

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;

    public UserRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query(GET_ALL_USERS, userMapper);
    }

    @Override
    public User getUserById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.query(GET_USER_BY_ID, params, userMapper).stream().findFirst().orElse(null);
    }

    @Override
    public void createUser(User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", user.getName());
        params.addValue("email", user.getEmail());
        jdbcTemplate.update(CREATE_USER, params);
    }

    @Override
    public void updateUser(int id, User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        params.addValue("name", user.getName());
        params.addValue("email", user.getEmail());
        jdbcTemplate.update(UPDATE_USER, params);
    }

    @Override
    public void deleteUserById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(DELETE_USER_BY_ID, params);
    }
}
