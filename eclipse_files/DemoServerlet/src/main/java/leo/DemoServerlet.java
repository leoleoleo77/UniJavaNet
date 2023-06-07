package leo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Servlet implementation class DemoServerlet
 */
@WebServlet("/DemoServerlet")
public class DemoServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource datasource = null;
	public void init() throws ServletException{
		try {
	
			InitialContext ctx = new InitialContext();
			datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/LiveDataSource");
		} catch(Exception e) {
			throw new ServletException(e.toString());
		}

	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<h1>hello</h1>");
		PrintWriter out = response.getWriter();
		
		try (
			Connection con = datasource.getConnection();
			Statement stmt = con.createStatement();
		) {
			String sqlInsert = "INSERT INTO users VALUES (1, 'leo', 'leo@hi.com', '6925', '123', 'user');";
			/*ResultSet rs = stmt.executeQuery("INSERT INTO users VALUES (1, leo, leo@hi.com, '6925', '123', user);");
			while(rs.next()) {
				String print = rs.getString("user_id");
				out.println(print);
			}
			rs.close();*/
			//int countInserted = stmt.executeUpdate(sqlInsert);
	        System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
	        int countInserted = stmt.executeUpdate(sqlInsert);
	        System.out.println(countInserted + " records inserted.\n");
			con.close();
		} catch(Exception e) {
			out.println("Database connection problem");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
