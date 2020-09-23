package ro.dcatalin.byblios.checks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditorsOff")
public class EditorsDDL extends HttpServlet {

	private static final long serialVersionUID = 8904294765422974L;

	protected void doGet(HttpServletRequest req, HttpServletResponse ret) throws ServletException, IOException {
		String user = "root";
		String pass = "EmC2014#";
		String jdbcUrl = "jdbc:mysql://10.220.74.207:3306/rdc_security?useSSL=false&serverTimezone=Europe/Bucharest";
		String driver = "com.mysql.jdbc.Driver";
		String splashQuery = "CREATE TABLE `TBL_EDITORS` ("
		        + "`EDITOR_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'identificator unic al unei edituri',"
		        + "`EDITOR_NAME` varchar(32) NOT NULL COMMENT 'nume editura',"
		        + "`ADDRESS` varchar(128) NOT NULL COMMENT 'adresa sediului editurii',"
		        + "`EDITOR_INFO` varchar(2048) NOT NULL COMMENT 'scurta prezentare a unei edituri',"
		        + "PRIMARY KEY (`EDITOR_ID`), UNIQUE INDEX `EDITOR_ID_IDX` (`EDITOR_ID` ASC))"
		        + "ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE = utf8_unicode_ci "
		        + "COMMENT = 'câteva edituri de carte'";

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
			if ( ! splashStmnt.execute(splashQuery) ) {
				out.println("<td>TABLE</td><td>tbl_editors is now created</td>");
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

