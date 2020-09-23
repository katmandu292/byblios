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



@WebServlet("/AuthorsOff")
public class AuthorsDDL extends HttpServlet {

	private static final long serialVersionUID = 8904294765422967L;

	protected void doGet(HttpServletRequest req, HttpServletResponse ret) throws ServletException, IOException {
		String user = "root";
		String pass = "EmC2014#";
		String jdbcUrl = "jdbc:mysql://10.220.74.207:3306/rdc_security?useSSL=false&serverTimezone=Europe/Bucharest";
		String driver = "com.mysql.jdbc.Driver";
		String splashQuery = "CREATE TABLE `TBL_AUTHORS` ("
        + "`PERS_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificator unic al unui autor de carte',"
        + "`BIRTH_YEAR` MEDIUMINT NOT NULL DEFAULT 1900 COMMENT 'Anul nasterii autorului',"
        + "`AUTH_NAME` VARCHAR(64) NOT NULL DEFAULT 'John Doe' COMMENT 'Numele de publicare al unui autor de carte',"
        + "`AUTH_BIO` TEXT NOT NULL COMMENT 'scurta prezentare a unui autor de carte',"
        + " PRIMARY KEY (`PERS_ID`), UNIQUE INDEX `PERS_ID_IDX` (`PERS_ID` ASC))"
        + " ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_unicode_ci"
        + " COMMENT = 'lista autorilor de literatura'";

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
				out.println("<td>TABLE</td><td>tbl_authors is now created</td>");
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
