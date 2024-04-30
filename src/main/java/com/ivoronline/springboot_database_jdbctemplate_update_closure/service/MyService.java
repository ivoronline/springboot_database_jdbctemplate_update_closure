package com.ivoronline.springboot_database_jdbctemplate_update_closure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

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
