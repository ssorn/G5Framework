package dataBase;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DatabaseData {
 DataBase database;
 Logger log;

 public DatabaseData() {
  this.database  = database;
  log = Logger.getLogger(DatabaseData.class);
 }
 
 
 public String selectIdByName(String name) throws SQLException {
  String id;
  id = database.selectValue("select id from table where name='"+name+"'");
  return id;
 }
}