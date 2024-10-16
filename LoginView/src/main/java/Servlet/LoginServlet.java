package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sql.ConnectionProvider;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetch from database and check if the user is actually good
		try{
			Connection con = ConnectionProvider.getConnection();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = 	pst.executeQuery();
			
			try {
			PrintWriter p = response.getWriter();
			if(rs.next()) {
				p.println("successfullyy registered welcome "+ email);
			}
			else {
				p.println("LOL");
			}
			
			con.close();
			
	    }
		catch(Exception e){
			e.printStackTrace();
		}
			
		}
			
			
			
			
			
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
