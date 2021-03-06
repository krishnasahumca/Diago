package sqlconnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import config.Reading_Properties;
public class Sqlconnectionradinfodb {
	private static Connection conn;
  public static Connection dbConnect(WebDriver driver) throws IOException 
              {
	  Reading_Properties rp=new Reading_Properties();
      rp.LoadProperties(driver);
	   
	          try {

	        	  Class.forName(rp.getPropertyValue("DB_DRIVER_CLASS"));
	        	 /* Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  */
	              /*return conn = DriverManager.getConnection("jdbc:sqlserver://MWEB-GBD3DUC041;databaseName=mydb;user=sa;password=welcome1!");*/
	        	  return conn = DriverManager.getConnection(rp.getPropertyValue("radinfo_DB_URL"),rp.getPropertyValue("DB_USERNAME"),rp.getPropertyValue("DB_PASSWORD"));
	          }
	          catch (SQLException | ClassNotFoundException ex) 
	          {
	              ex.printStackTrace();
	              return null;
	          } 
       }
  
  public static void dbConnectionClose() {

	         try {
              if (conn != null && !conn.isClosed()) 
              {
                  conn.close();
              }
          } 
          catch (SQLException ex) 
          {
              ex.printStackTrace();
          }
      }
}