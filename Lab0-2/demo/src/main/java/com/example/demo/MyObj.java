package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MyObj {
    private final JdbcTemplate jdbcTemplate;

    public MyObj(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MyObject> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM my_objects",
                (rs, rowNum) -> new MyObject(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description")
                )
        );
    }

    public void save(MyObject obj) {
        jdbcTemplate.update(
                "INSERT INTO my_objects (name, description) VALUES (?, ?)",
                obj.getName(), obj.getDescription()
        );
    }

    public void update(Long id, MyObject obj) {
        jdbcTemplate.update(
                "UPDATE my_objects SET name=?, description=? WHERE id=?",
                obj.getName(), obj.getDescription(), id
        );
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM my_objects WHERE id=?", id);
    }
}
