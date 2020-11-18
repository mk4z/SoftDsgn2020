package com.example.wsp_spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DBRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DBRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AuthnData findAuthnData(String userId, String userPassword) {
        String sql = "select user_id, user_password, user_name " +
                "from authn_data " +
                "where user_id = ? and user_password = ?";
        AuthnData authnData = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(AuthnData.class),
                userId, userPassword);
        System.out.println(authnData.getUserId() + ", " + authnData.getUserName());
        return authnData;
    }

    public int insertAuthnData(AuthnData authnData) throws DataAccessException {
        String sql = "insert into authn_data(user_id, user_password, user_name) " +
                "values(?, ?, ?)";
        String userId = authnData.getUserId();
        String userPassword = authnData.getUserPassword();
        String userName = authnData.getUserName();
        return jdbcTemplate.update(sql, userId, userPassword, userName);
    }

    public int insertToDoItem(String userId, String subject, String body) {
        String sql = "insert into todo_item " +
                "values(?, ?, ?)";
        return jdbcTemplate.update(sql, userId, subject, body);
    }

    public List<ToDoItem> findToDoItemsByUserId(String userId) {
        String sql = "select * from todo_item where user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ToDoItem.class), userId);
    }

}
