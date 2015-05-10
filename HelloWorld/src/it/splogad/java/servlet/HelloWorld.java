package it.splogad.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(urlPatterns="/HelloWorld", initParams={
			@WebInitParam(name="type", value="checking")
			})
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Set response content type
	    response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();
	    insertCookie(response);
	    
	        
	    pw.println("<html> <head></head>");
		pw.println("<body>");
		pw.println("<h1>Hello World</h1>");
		
		pw.println(request.getParameter("type"));
		pw.println("</body></html>");
		//response.sendRedirect("http://www.google.it");
	}
	
	protected void insertCookie(HttpServletResponse res){
		//Create a Simple Cookie that it wil be shown on the webpage
		Cookie cookie_name = new Cookie("NomeDev", "splogad");
		res.addCookie(cookie_name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
