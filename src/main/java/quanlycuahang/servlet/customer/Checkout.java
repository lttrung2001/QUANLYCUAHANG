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
        
        // Tạo bill
        try {
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			String now = getToday();
			String createBillStatement = String.format("INSERT INTO BILL (CREATE_AT, DELIVER_ADDRESS) VALUES (N'%s', N'%s')", now, address);
			String getBillId = String.format("SELECT BILL_ID FROM BILL WHERE CREATE_AT = N'%s'", now);
			Statement statement = conn.createStatement();
			statement.executeUpdate(createBillStatement);
			ResultSet rs = statement.executeQuery(getBillId);
			rs.next();
			String billId = rs.getString("BILL_ID");
			
            String insertToBD = "";
            for (int i = 0; i < idArray.length; i++) {
				insertToBD = String.format("INSERT INTO BILL_DETAIL VALUES (%s,%s,%s)",
											billId,
											idArray[i],
											amountArray[i]);
				statement.executeUpdate(insertToBD);
            }
            String removeFromCart = String.format("DELETE FROM CART WHERE ACCOUNT_ID = N'%s'", account.getUsername());
            statement.executeUpdate(removeFromCart);
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
