package mainpackage.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.Statement;

import  mainpackage.login.LoginBean;

public class LoginDao {
    private DataSource datasource = null;

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        Class.forName("com.mysql.jdbc.Driver");

    	try {
    	
    		InitialContext ctx = new InitialContext();
    		datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/LiveDataSource");
    	} catch(Exception e) {
    		System.out.println(e.toString());
    	}

    	
        
        try (Connection con = datasource.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = con
            .prepareStatement("select * from users where username = ? and user_password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
		return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
