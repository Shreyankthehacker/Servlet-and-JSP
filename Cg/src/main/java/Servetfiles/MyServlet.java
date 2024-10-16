package Servetfiles;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("null")
	public static int  marks(String s) {
		if(s.equals("aa"))return 10;
		if(s.equals("ab"))return 9;
		if(s.equals("bb"))return 8;
		if(s.equals("bc"))return 7;
		if(s.equals("cc"))return 6;
		if(s.equals("cd"))return 5;
		if(s.equals("dd"))return 4;
		return 0;
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int coa = 3*marks(request.getParameter("coa"));
		
		int dbms = 3*marks(request.getParameter("dbms"));
		int software = 3*marks(request.getParameter("software"));
		int mpmc = 3*marks(request.getParameter("mpmc"));
		int maths = 4* marks(request.getParameter("maths"));
		int hst = 3*marks(request.getParameter("hst"));
		int coalab = marks(request.getParameter("coalab"));
		int dbmslab = marks(request.getParameter("dbmslab"));
		int python = 2*marks(request.getParameter("python"));
		int mpmclab = 2* marks(request.getParameter("mpmclab"));
		int otp = marks(request.getParameter("otp"));
		Float cgpa = Float.parseFloat(request.getParameter("cg"));
		float sg = 0f;
		sg = (coa+dbms+software+mpmc+maths+hst+coalab+dbmslab+python+mpmclab+otp)/26;
		cgpa = (cgpa*52+sg*26)/78;
		request.setAttribute("cg", cgpa);
		request.setAttribute("sg", sg);
		try {
			response.getWriter().append("<h1> Congrats your CGPA is "+cgpa+" and your sgpa is "+sg+ " </h1>");
			//response.getWriter().append("welcome");
			}
			catch(Exception e ) {
				e.printStackTrace();
			}
		}
		catch(Exception e ) {
			
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	doGet(request,response);}

	
}
