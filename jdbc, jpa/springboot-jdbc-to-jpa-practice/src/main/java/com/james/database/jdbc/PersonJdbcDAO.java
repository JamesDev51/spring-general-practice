package com.james.database.jdbc;

import com.james.database.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

//@Repository
public class PersonJdbcDAO {

      @Autowired
      JdbcTemplate jdbcTemplate;

      class PersonRowMapper implements  RowMapper<Person>{
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                  Person person = new Person();
                  person.setId(rs.getInt("id"));
                  person.setName(rs.getString("name"));
                  person.setLocation(rs.getString("location"));
                  person.setBirthDate(rs.getTimestamp("birth_date"));
                  return person;
            }
      }

      //select * from person
      public List<Person> findAll(){
            return jdbcTemplate.query("select * from person",
                        new BeanPropertyRowMapper<>(Person.class));
      }
      //select * from person
      public Person findById(int id){
            return jdbcTemplate.queryForObject("select * from person where id=? ", new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class));
      }

      //select * from person
      public int deleteById(int id){
            return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
      }

      //select * from person
      public int insert(Person person){
            return jdbcTemplate.update("INSERT INTO PERSON (ID,NAME,LOCATION,BIRTH_DATE) VALUES(?,?,?,?);",
                        new Object[]{
                                    person.getId(),
                                    person.getName(),
                                    person.getLocation(),
                                    new Timestamp(person.getBirthDate().getTime())});
      }

     //select * from person
      public int update(Person person){
            return jdbcTemplate.update("update  PERSON set name=?, location=?, birth_date=? where id=?;",
                        new Object[]{
                                    person.getName(),
                                    person.getLocation(),
                                    new Timestamp(person.getBirthDate().getTime()),
                                    person.getId()});
      }




}
