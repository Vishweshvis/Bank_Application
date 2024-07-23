package com.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration1
 */
@WebServlet("/registration1")
public class registration1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullname = request.getParameter("name");
		 //String password = generate_password();
		String address = request.getParameter("address");
		String emailid = request.getParameter("email");
		String typeofaccount = request.getParameter("typeofaccount");
		String idproof = request.getParameter("idproof");
		String initialamount = request.getParameter("amount");
		String dob = request.getParameter("dob");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
        RequestDispatcher dispatcher = null;
        Connection con = null;
PrintWriter out = response.getWriter();
response.sendRedirect("account.jsp");


try {
	Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details","root","Vikkyrover@8056");
	PreparedStatement pst = con.prepareStatement("insert into details(fullname , address,User_Email , TypeofAccount , initialamount , dataofbirth, idproof,city,state, zipcode ) values(?,?,?,?,?,?,?,?,?,?)");
	pst.setString(1, fullname);
	pst.setString(2, address);
	pst.setString(3, emailid);
	pst.setString(4, typeofaccount);
	pst.setString(5, initialamount);
	pst.setString(6, dob);

	pst.setString(7, idproof);
	
	
	pst.setString(8, city);
	pst.setString(9, state);
	pst.setString(10, zipcode);
	int rowcount = pst.executeUpdate();
	dispatcher = request.getRequestDispatcher("template.jsp");
 
	if(rowcount > 0) {
	 request.setAttribute("status","success");

	} 
	else {
		request.setAttribute("status","failed");
	}
	//dispatcher.forward(request, response);

} catch (ClassNotFoundException  | SQLException e) {
	// TODO Auto-generated catch block
	System.out.println(e);
}
finally {
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }


	}
	
	

	


}
