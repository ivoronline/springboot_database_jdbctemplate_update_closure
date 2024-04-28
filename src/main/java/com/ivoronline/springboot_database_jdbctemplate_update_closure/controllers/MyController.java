package com.ivoronline.springboot_database_jdbctemplate_update_closure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.PreparedStatement;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //=========================================================================================================
  // HELLO
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/hello")
  public int hello() {
    int    updatedRecords = update("John New2", "John", 10);
    return updatedRecords;
  }

  //=========================================================================================================
  // UPDATE
  //=========================================================================================================
  public int update(String newName, String oldName, Integer age) {

    return jdbcTemplate.update(connection -> {

      String            sql               = " UPDATE PERSON SET NAME = ? WHERE NAME = ? AND AGE = ?";

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, newName);
                        preparedStatement.setString(2, oldName);
                        preparedStatement.setLong  (3, age    );

        return preparedStatement;

      }

    );

  }

}
