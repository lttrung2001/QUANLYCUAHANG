package quanlycuahang.servlet.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchKey = request.getParameter("searchKey");
		String dbURL = "jdbc:sqlserver://localhost:1433; Database=QUANLYCUAHANG";
        String user = "sa";
        String pass = "tt";
        
        try {
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			String sqlString;
			if (searchKey.isBlank()) {
				sqlString = "SELECT * FROM PRODUCT";
			}
			else {
				sqlString = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE N'%"+searchKey+"%'";
			}
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlString);
            if (rs.getFetchSize() == 0) return;
            while (rs.next()) {
//            	response.getWriter().print(String.format("<div><span style=\"display: none;\">%s</span><span class=\"search-name\">%s</span></div>", rs.getString(1),rs.getString(2)));
            	response.getWriter().print(String.format("<div class=\"items\">\r\n"
            			+ "				<figure>\r\n"
            			+ "					<img src=\".%s\" alt=\"\" class=\"img-items\">\r\n"
            			+ "					<p class=\"price-item\">%f</p>\r\n"
            			+ "					<p style=\"display: none;\" class=\"describe-item\">%s</p>\r\n"
            			+ "					<a href=\"#\"><p>%s</p></a>\r\n"
            			+ "					<p style=\"display: none;\" class=\"id-item\">%d</p>\r\n"
            			+ "				</figure>\r\n"
            			+ "				<div onclick=\"test(this);\" class=\"buy-item\">\r\n"
            			+ "					<h2>BUY NOW</h2>\r\n"
            			+ "				</div>\r\n"
            			+ "			</div>", rs.getString(5),rs.getDouble(4),rs.getString(3),rs.getString(2),rs.getInt(1)));
            }
            conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
