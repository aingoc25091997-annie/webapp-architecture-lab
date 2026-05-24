package com.annie.webapp.repository;

import com.annie.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        String sql = "INSERT INTO users (username, email, password, firstname, lastname, address) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql);
    }

    @Override
    public Optional<User> findByUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                return u;
            }, username);
            return Optional.of(null != user ? user : null);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
