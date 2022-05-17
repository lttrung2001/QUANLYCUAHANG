package quanlycuahang.servlet.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanlycuahang.entity.ClientAccount;

/**
 * Servlet implementation class DeleteProductInCart
 */
@WebServlet("/DeleteProductInCart")
public class DeleteProductInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductInCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		ClientAccount account = (ClientAccount) session.getAttribute("account");
		int productId = Integer.parseInt(request.getParameter("productId"));
		String accountId = account.getUsername();
		
		String dbURL = "jdbc:sqlserver://localhost:1433; Database=QUANLYCUAHANG";
        String user = "sa";
        String pass = "tt";
        
        try {
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			String sqlString = String.format("DELETE FROM CART WHERE PRODUCT_ID = %d AND ACCOUNT_ID = %s", productId, accountId);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlString);
            conn.commit();
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
