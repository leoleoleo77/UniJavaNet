package mainpackage.servlets.films;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class AddFilms
 */
@WebServlet("/AddFilms")
public class AddFilms extends HttpServlet {
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
    public AddFilms() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String requestType= request.getParameter("requestType");
		if (requestType == null) {
			createDynPage(response, "Invalid request type");
		}
		
		if (requestType.equalsIgnoreCase("insert")) {
			String id = request.getParameter("film_id");
			String title = request.getParameter("title");
			String duration = request.getParameter("duration");
			int iex1 = 0;
			try {
				iex1 = Integer.parseInt(id);
			} catch(Exception e) {
				//create a dynamic error page informing the client about the parameter values/type
				e.printStackTrace();
			}
			
			try {
				Connection con = datasource.getConnection();
				
			    Statement stmt = con.createStatement();
			    StringBuilder x = new StringBuilder();
			   
			    String insertStmt = "INSERT INTO films (film_id, title, duration)" + " VALUES (";
			    insertStmt +=  id + ",";
			    insertStmt += "'" + title + "',";
			    insertStmt += "'" + duration + "')";
			    
			    stmt.executeUpdate(insertStmt);
			    createDynPage(response, "film added!");
				stmt.close();
			
				con.close();
				
			} catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
		} else {
			createDynPage(response, "The request type parameter must be insert");
		}
	}
	
	private void createDynPage(HttpServletResponse response, String message) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Add film</title></head>");
		out.println("<body>");
		out.println("<p>" + message + "</p>");
		out.println("<a href=\'/DemoServerlet/index.html'>back to home</a>");
		out.println("</body></html>");
	}


}
