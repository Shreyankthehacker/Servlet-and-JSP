package pack;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/UploadingServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB

public class UploadingServlet extends HttpServlet {
	 private static final String UploadDir = "UploadedFiles";
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}
	
	
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	//	doGet(request, response);
//		response.setContentType("text/html");
//		
//	//	String path = this.getServletConfig().getServletContext().getRealPath("UploadedFiles");
//		String path = System.getProperty("user_dir")+"//servlet3.x//src//main//webapp//UploadedFiles";
//		PrintWriter pwt = response.getWriter();
//		pwt.print("<html><body bgcolor = yellow>");		
//		pwt.print(path);
//		MultipartRequest mpr = MultipartRequest(request,path,20*1024*1024);
//		String st = mpr.getoriginalFileName("file");
//		pwt.println(st);
//		String id = mpr.getParameter("textname");
//		pwt.print("user id :"+id);
//		pwt.print("file uplaoded..........");
//		pw.print("</body></html>");
//		pwt.close();
//		
	   String appPath = request.getServletContext().getRealPath("");
	   String uploadPath = appPath+File.separator+UploadDir;
	   
	   // create a file if doesnt exist 
	   File fileSaveDir = new File(uploadPath);
	   if(!fileSaveDir.exists()) {
		   fileSaveDir.mkdir();
	   }
	   PrintWriter pt = response.getWriter();
	   pt.println("Upload file directpry = "+fileSaveDir.getAbsolutePath());
	   String fileName= null;
	   for(Part part:request.getParts()){
		   fileName = getFileName(part);
		   part.write(uploadPath + File.separator + fileName);
	   }
	   request.setAttribute("message", fileName + " File uploaded successfully!");
       pt.println(fileName + " file uploadded successfully");
	   
	   
	}
   /**
    * Utility method to get file name from HTTP header content-disposition
    */
   private String getFileName(Part part) {
       String contentDisp = part.getHeader("content-disposition");
       System.out.println("content-disposition header= "+contentDisp);
       String[] tokens = contentDisp.split(";");
       for (String token : tokens) {
           if (token.trim().startsWith("filename")) {
               return token.substring(token.indexOf("=") + 2, token.length()-1);
           }
       }
       return "";
   }

}
