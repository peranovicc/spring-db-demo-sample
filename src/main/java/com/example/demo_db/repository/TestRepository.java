package com.example.demo_db.repository;

import com.example.demo_db.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getRandomName(){
        String query = "SELECT sIme as ime, prezime, sId as id FROM student";

        List<Student> students = jdbcTemplate.query(
                query,
                BeanPropertyRowMapper.newInstance(Student.class)
        );

        return students.get(0).getIme();
    }
}
