package com.example.wsp_spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBRepositpry {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DBRepositpry(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AuthnData findAuthnData(String userId, String userPassword) {
        String sql = "select user_id, user_password, user_name " +
                "from authn_data where user_id = ? and user_password = ?";
        AuthnData authnData = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(AuthnData.class),
                userId, userPassword);

        System.out.println(authnData.getUserId() + ", " + authnData.getUserName());

        return authnData;
    }

    public int insertAuthnData(AuthnData authnData) {
        String sql = "insert into authn_data(user_id, user_password, user_name) " +
                "values(?, ?, ?)";
        String userId = authnData.getUserId();
        String userPassword = authnData.getUserPassword();
        String userName = authnData.getUserName();

        return jdbcTemplate.update(sql, userId, userPassword, userName);
    }

}
