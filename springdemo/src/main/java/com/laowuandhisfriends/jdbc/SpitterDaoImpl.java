package com.laowuandhisfriends.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class SpitterDaoImpl extends JdbcDaoSupport implements SpitterDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

//    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }


    @Override
    public void addSpitter(Spitter spitter) {
//        jdbcTemplate.update("insert into spitter(username, password, full_name) values(?,?,?)",
//                spitter.getUsername(), spitter.getPassword(), spitter.getFullName());

//        String sql = "insert into spitter(username,password,full_name)" +
//                "values(:username, :password, :fullName)";
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("username", spitter.getUsername());
//        params.put("password", spitter.getPassword());
//        params.put("fullName", spitter.getFullName());
//
//        namedParameterJdbcTemplate.update(sql, params);

        getJdbcTemplate().update("insert into spitter(username, password, full_name) values(?,?,?)",
                spitter.getUsername(), spitter.getPassword(), spitter.getFullName());
    }

    @Override
    public long addSpitterAndGetAutoIncreaseId(Spitter spitter) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        long autoIncId = 0;

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("insert into spitter(username, password, full_name) values(?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, spitter.getUsername());
            ps.setString(2, spitter.getPassword());
            ps.setString(3, spitter.getFullName());
            return ps;
        }, keyHolder);

        autoIncId = keyHolder.getKey().longValue();
        return autoIncId;
    }

    @Override
    public void updateSpitter(Spitter spitter) {
        jdbcTemplate.update("update spitter set email = ?, update_email = ?",
                spitter.getEmail(), spitter.isUpdateEmail());
    }

    @Override
    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject("select * from spitter where id = ?", (rs, rowNUm) -> {
            Spitter spitter = new Spitter();
            spitter.setId(rs.getLong(1));
            spitter.setUsername(rs.getString(2));
            spitter.setPassword(rs.getString(3));
            spitter.setFullName(rs.getString(4));
            spitter.setEmail(rs.getString(5));
            spitter.setUpdateEmail(rs.getBoolean(6));
            return spitter;
        }, id);
    }
}
