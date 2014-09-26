package dataBase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import libs.Utill;
import org.apache.log4j.Logger;

public class DataBaseData {
 DataBase database;
 Logger log;
 util = new Util();

 public DataBaseData(DataBase database) {
  this.database  = database;
  log = Logger.getLogger(DataBaseData.class);
 }
 
 
 public String selectIdByName(String name) throws SQLException {
  String id;
  id = database.selectValue("select id from table where name='"+name+"'");
  return id;
 }
 
 public void getTableFromDB() throws SQLException, IOException {
	  List<ArrayList<String>> table;
	  table = database.selectTable("query that returns table");
	  Util.printTable(table);
	 }
}