package libs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class Utill {
	
	static Logger log;
	
		
	
	
	
	/**
	  * This method is used to kill all opened Firefox processes
	  */
	  public static void killAllProcesses() {
	  try {
	   Process process = Runtime.getRuntime().exec("cmd /c Taskkill /IM firefox.exe /F");
	   process.waitFor();
	   // log.info("All Firefox processes closed.");
	  } catch (Exception e) {
	   e.printStackTrace();
	  }

	 }/*
	   * Static method that prints List's values in the form of table
	   */
	  public static void printTable(List<ArrayList<String>> list) throws SQLException, IOException {
	   int columnNumber = list.get(0).size();
	   int listSize = list.size();

	   // Make even length of values
	   for (int k = 0; k < columnNumber; k++) {
	    for (int i = 0; i < listSize; i++) {
	     if ((list.get(i).get(k).toString().length() % 2) == 1) {
	      String value = list.get(i).get(k).toString() + " ";
	      list.get(i).set(k, value);
	     }
	    }
	   }

	   // Add additional spaces before and after the values
	   for (int k = 0; k < columnNumber; k++) {
	    for (int i = 0; i < listSize; i++) {
	     String value = " " + list.get(i).get(k).toString() + " ";
	     list.get(i).set(k, value);
	    }
	   }

	   // Create array with every column's length and middle
	   int[] columnLength = new int[columnNumber];
	   int[] columnMiddle = new int[columnNumber];

	   for (int k = 0; k < columnNumber; k++) {
	    int maxLength = 0;
	    for (int i = 0; i < listSize; i++) {
	     if (list.get(i).get(k).toString().length() > maxLength) {
	      maxLength = list.get(i).get(k).toString().length();
	     }
	    }
	    columnLength[k] = maxLength;
	    columnMiddle[k] = maxLength / 2;
	   }

	   // Print table delimiter
	   for (int k = 0; k < columnNumber; k++) {
	    for (int j = 0; j < columnLength[k]; j++) {
	     System.out.print("-");
	     addText(getCfgValue("TEST_LOG_FILE"), "-");
	    }
	    System.out.print("|");
	    addText(getCfgValue("TEST_LOG_FILE"), "|");
	   }
	   System.out.print("\n");
	   addText(getCfgValue("TEST_LOG_FILE"), "\n");

	   // Print row by row
	   for (int i = 0; i < listSize; i++) {

	    // Print table header delimiter
	    if (i == 1) {
	     for (int k = 0; k < columnNumber; k++) {
	      for (int j = 0; j < columnLength[k]; j++) {
	       System.out.print("-");
	       addText(getCfgValue("TEST_LOG_FILE"), "-");
	      }
	      System.out.print("|");
	      addText(getCfgValue("TEST_LOG_FILE"), "|");
	     }
	     System.out.print("\n");
	     addText(getCfgValue("TEST_LOG_FILE"), "\n");
	    }

	    // Print cells in the row
	    for (int k = 0; k < columnNumber; k++) {

	     int spaceNumber = columnMiddle[k] - (list.get(i).get(k).toString().length() / 2);
	     for (int j = 0; j < spaceNumber; j++) {
	      System.out.print(" ");
	      addText(getCfgValue("TEST_LOG_FILE"), " ");
	     }
	     System.out.print(list.get(i).get(k));
	     addText(getCfgValue("TEST_LOG_FILE"), list.get(i).get(k).toString());
	     for (int j = 0; j < spaceNumber; j++) {
	      System.out.print(" ");
	      addText(getCfgValue("TEST_LOG_FILE"), " ");
	     }
	     System.out.print("|");
	     addText(getCfgValue("TEST_LOG_FILE"), "|");
	    }

	    System.out.print("\n");
	    addText(getCfgValue("TEST_LOG_FILE"), "\n");
	   }

	   // Print table delimiter
	   for (int k = 0; k < columnNumber; k++) {
	    for (int j = 0; j < columnLength[k]; j++) {
	     System.out.print("-");
	     addText(getCfgValue("TEST_LOG_FILE"), "-");
	    }
	    System.out.print("|");
	    addText(getCfgValue("TEST_LOG_FILE"), "|");
	   }
	   System.out.print("\n");
	   addText(getCfgValue("TEST_LOG_FILE"), "\n");
	  }
	  
	  
	  /*
	   * Add text at the end of text file
	   */
	  public static void addText(String filePath, String text) throws IOException {
	   BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
	   out.write(text);
	   out.close();
	  }
	  
	  
	  /*
	   * Check if the test failed or not and complete the test.
	   */
	  public static void testResult(boolean isTestPassed) {
	   if (!isTestPassed) {
	    log.error("TEST FAILED");
	    Assert.fail();
	   }
	   log.info("TEST SUCCESSFULLY COMPLETED");

	  }
	  
	
}
