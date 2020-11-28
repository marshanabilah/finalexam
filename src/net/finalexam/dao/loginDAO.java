package net.finalexam.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import net.finalexam.model.login;
 
public class loginDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/uas?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "bela2000";
	
	public loginDAO() {
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public String authenticateUser(login login){
        String userName = login.getUsername(); //Assign user entered values to temporary variables.
        String password = login.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";

        try{
            con = getConnection(); //Fetch database connection object
            statement = con.createStatement(); //Statement is used to write queries. Read more about it.
            resultSet = statement.executeQuery("select userName,password from users"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.

            while(resultSet.next()) // Until next row is present otherwise it return false
            {
             userNameDB = resultSet.getString("userName"); //fetch the values present in database
             passwordDB = resultSet.getString("password");

              if(userName.equals(userNameDB) && password.equals(passwordDB)){
                 return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
              }
            }
        }
            catch(SQLException e)
            {
               e.printStackTrace();
            }
            return "Invalid user credentials"; // Return appropriate message in case of failure	
     }
}