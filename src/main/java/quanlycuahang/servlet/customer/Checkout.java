package quanlycuahang.servlet.customer;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quanlycuahang.entity.ClientAccount;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private String getToday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");  
	    Date date = new Date();  
	    return formatter.format(date);  
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ClientAccount account = (ClientAccount) session.getAttribute("account");
		
		String ids = request.getParameter("ids");
		String amounts = request.getParameter("amounts");
		String address = request.getParameter("billAddress");
		ids = ids.replace("[", "");
		ids = ids.replace("]", "");
		amounts = amounts.replace("[", "");
		amounts = amounts.replace("]", "");
		String idArray[] = ids.split(",");
		String amountArray[] = amounts.split(",");
		
		
		String dbURL = "jdbc:sqlserver://localhost:1433; Database=QUANLYCUAHANG";
        String user = "sa";
        String pass = "tt";
        Connection conn = null;
        try {
			conn = DriverManager.getConnection(dbURL, user, pass);
			String now = getToday(); // Get current date time
			String createBillStatement = String.format("INSERT INTO BILL (CREATE_AT, DELIVER_ADDRESS) VALUES (N'%s', N'%s')", now, address);
			String getBillId = String.format("SELECT BILL_ID FROM BILL WHERE CREATE_AT = N'%s'", now);
			Statement statement = conn.createStatement();
			// Create bill
			statement.executeUpdate(createBillStatement);
			// Get bill id have just added
			ResultSet rs = statement.executeQuery(getBillId);
			rs.next();
			String billId = rs.getString("BILL_ID");
			// Insert products into bill detail
            String insertToBD = "";
//            String minusQttInStock = "";
            for (int i = 0; i < idArray.length; i++) {
				insertToBD = String.format("INSERT INTO BILL_DETAIL VALUES (%s,%s,%s)",
											billId,
											idArray[i],
											amountArray[i]);
				statement.executeUpdate(insertToBD);
//				minusQttInStock = String.format("UPDATE PRODUCT "
//												+ "SET QTT_IN_STOCK = QTT_IN_STOCK - %s "
//												+ "WHERE PRODUCT_ID = '%s'", amountArray[i],idArray[i]); 
//				statement.executeUpdate(minusQttInStock);
            }
            // Delete products in cart
//            statement.executeUpdate(String.format("DELETE FROM CART WHERE ACCOUNT_ID = N'%s'", account.getUsername()));
            conn.commit();
            conn.close();
        } catch (SQLException e) {
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
