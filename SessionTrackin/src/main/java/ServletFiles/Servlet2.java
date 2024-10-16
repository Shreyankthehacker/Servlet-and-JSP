package ServletFiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			try{
				response.getWriter().append("<h1> Name is "+name + " and your password is "+password+" from SERVLET -2 ");
//				Cookie cookies[] = request.getCookies();
				PrintWriter p = response.getWriter();
//				for(Cookie c: cookies) {
//					p.println(c.getName()+" "+c.getValue());
//				}
//				
			HttpSession session = request.getSession();
			name = (String) session.getValue("name");
			password = (String) session.getValue("password");
			if(!session.isNew()) {
				session.invalidate();
				p.print("<a form = 'index.html'>");
			}
					response.getWriter().append("<h1> Name is "+name + " and your password is "+password+" from SERVLET -2 ");
				}
			catch(Exception e ) {
				e.printStackTrace();
		}}
		catch(Exception e ) {
			e.printStackTrace();
		}
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
