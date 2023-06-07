package mainpackage.servlets.films;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class DBServlet
 */
@WebServlet("/ShowFilms")
public class ShowFilms extends HttpServlet {
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
	public ShowFilms() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>All films</title></head>");
		out.println("<body>");

		try {
			Connection con = datasource.getConnection();
			Statement stmt = con.createStatement();
	
			out.println("<table border=\"1\">");
			out.println("<tr>");
			out.println("<th>id</th>");
			out.println("<th>title</th>");
			out.println("<th>duration</th>");
			out.println("</tr>");


			ResultSet rs = stmt.executeQuery("SELECT * FROM films");
			while(rs.next()) {
				int code = rs.getInt("film_id");
				String title = rs.getString("title");
				int duration = rs.getInt("duration");
				//int ex1 = rs.getInt("grade");
				String htmlRow = createHTMLRow(code, title, duration);
				out.println(htmlRow);

			}
			rs.close();

			con.close();
		} catch(Exception e) {
			out.println("Database connection problem");
		}

		out.println("</body>");
		out.println("</html>");

	}

	private String createHTMLRow(int id, String title, int duration) {
		String row = "<tr>";
		row  += "<td>" + id + "</td>";
		row  += "<td>" + title + "</td>";
		row  += "<td>" + duration + "</td>";
		row +="</tr>";
		return row;

	}
}
