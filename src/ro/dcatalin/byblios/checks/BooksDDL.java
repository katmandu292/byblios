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


@WebServlet("/BooksOff")
public class BooksDDL extends HttpServlet {

	private static final long serialVersionUID = 8904294765422979L;

	protected void doGet(HttpServletRequest req, HttpServletResponse ret) throws ServletException, IOException {
		String user = "root";
		String pass = "EmC2014#";
		String jdbcUrl = "jdbc:mysql://10.220.74.207:3306/rdc_security?useSSL=false&serverTimezone=Europe/Bucharest";
		String driver = "com.mysql.jdbc.Driver";
		String splashQuery = "CREATE TABLE `TBL_BOOKS` ("
        + "`VOLUME_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificator Unic Carte',"
        + "`AUTHOR_ID` INT UNSIGNED NOT NULL COMMENT 'numarul unic de identificare al autorului',"
        + "`GENRE_ID` INT NOT NULL COMMENT 'identificator unic al genului in care se incadreaza volumul',"
        + "`LAUNCHED_BY` INT NOT NULL COMMENT 'identificatorul unic al editurii care a publicat cartea',"
        + "`LAUNCH_YEAR` INT NOT NULL COMMENT 'Anul publicarii cartii',"
        + "`ISBN` VARCHAR(32) NULL DEFAULT 'Not Available' COMMENT 'Codul ISBN sub care a fost publicata',"
        + "`VOL_TITLE` VARCHAR(64) NULL DEFAULT 'MORTULDINTRASURAGOALA' COMMENT 'Titlul sub care a fost publicata cartea',"
        + "`VOL_INFO` TEXT NOT NULL COMMENT 'scurt comentariu introspectiv asupra cartii', PRIMARY KEY (`VOLUME_ID`),"
        + "UNIQUE INDEX `BOOK_ID_UNIQUE` (`VOLUME_ID` ASC)) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 "
        + "COLLATE = utf8_general_ci COMMENT = 'Cartile/Volumele cu principalele atribute'";

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
				out.println("<td>TABLE</td><td>tbl_books is now created</td>");
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

