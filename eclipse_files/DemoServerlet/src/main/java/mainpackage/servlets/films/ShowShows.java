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
@WebServlet("/ShowShows")
public class ShowShows extends HttpServlet {
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
	public ShowShows() {
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
		out.println("<head><title>All shows</title></head>");
		out.println("<body>");

		try {
			Connection con = datasource.getConnection();
			Statement stmt = con.createStatement();
	
			out.println("<table border=\"1\">");
			out.println("<tr>");
			out.println("<th>room id</th>");
			out.println("<th>title</th>");
			out.println("<th>date</th>");
			out.println("</tr>");


			ResultSet rs = stmt.executeQuery("SELECT films.title, rooms.room_id, shows.show_time FROM ((shows INNER JOIN films ON shows.film_id = films.film_id) INNER JOIN rooms ON shows.room_id = rooms.room_id)");
			while(rs.next()) {
				int room_id = rs.getInt("room_id");
				String title = rs.getString("title");
				String show_time = rs.getString("show_time");
				//int ex1 = rs.getInt("grade");
				String htmlRow = createHTMLRow(room_id, title, show_time);
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

	private String createHTMLRow(int room_id, String title, String show_time) {
		String row = "<tr>";
		row  += "<td>" + room_id + "</td>";
		row  += "<td>" + title + "</td>";
		row  += "<td>" + show_time + "</td>";
		row +="</tr>";
		return row;

	}
}
