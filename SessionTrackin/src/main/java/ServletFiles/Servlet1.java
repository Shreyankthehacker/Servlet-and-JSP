package ServletFiles;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			try{
				response.getWriter().append("<h1> Name is "+name + " and your password is "+password+" from SERVLET -1 ");
				
				PrintWriter p = response.getWriter();
				response.setContentType("text/html");
			// This is using html action to pass the value
//				p.println("<html><body><form action = 'Servlet2' method = 'post'>");
//				p.println("<input type = 'hidden' name = 'name' value = '"+name+"'/>");
//				p.println("<input type = 'hidden' name = 'password' value = '"+password+"'/>");
//				p.println("<input type = 'submit' value = 'Submit'/>");
//				p.println("</form></body></html>");
//				
				// This is url rewriting (abstraction) to go to next servlet along with data
				
//				p.println("<a href = 'Servlet2?name="+name+"%20&pass="+password+"'> next ");
				
				//Cookies method
//				Cookie cookie1 = new Cookie("name",name);
//				Cookie cookie2 = new Cookie("passwod",password);
//				response.addCookie(cookie2);
//				response.addCookie(cookie1);
			//p.println(" <a href = 'Servlet2'>  Click here");
//				
				
				// The in use method HTTPSession tracking
				HttpSession session = request.getSession();
				
				
				if(session.isNew()) {
					p.println(session);
					session.setAttribute("name", name);
					session.setAttribute("password",password);
					p.println(" <a href = 'Servlet2'>  Click here");
				
				}
				else {
					p.print(session.getLastAccessedTime());
					
				}

				}
			catch(Exception e ) {
				e.printStackTrace();
		}}
		catch(Exception e ) {
			e.printStackTrace();
		}
	}

}
