package ro.dcatalin.byblios.checks;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServerUp")
public class ServerUp extends HttpServlet {

	private static final long serialVersionUID = 8904294765422951L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse ret) throws ServletException, IOException {
		String user = "root";
		String pass = "EmC2014#";
		String jdbcUrl = "jdbc:mysql://10.220.74.207:3306/rdc_security?useSSL=false&serverTimezone=Europe/Bucharest";
		String driver = "com.mysql.jdbc.Driver";
		String splashQuery = "SELECT MESSG_CONTENT FROM TBL_INFOS WHERE MESSG_ID > 1000";
		PrintWriter out = ret.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Book Tracker</title></head>");
		out.println("<link type=\"text/css\"  rel=\"stylesheet\" "
		                 + " href=\"resources/css/author.css\">");
		out.println("<body>");
//		get connection to database
		try {
		
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>PARAMETER</th>");
			out.println("<th>Value</th>");
			out.println("</tr>");
			out.println("<tr>");
			Statement splashStmnt = myConn.createStatement();
			ResultSet splashInfo = splashStmnt.executeQuery(splashQuery);

			while ( splashInfo.next() ) {
				out.println("<tr>" + splashInfo.getString("MESSG_CONTENT") + "</tr>");
			}

			out.println("</tr>");
			out.println("</table></body></html>");
			myConn.close();

		}
		catch (Exception exc) {
			out.println(exc.toString());
			exc.printStackTrace();
			out.println("</body></html>");
		}
	}
}

