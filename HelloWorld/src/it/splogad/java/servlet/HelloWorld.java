package it.splogad.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	    
	    HttpSession session = request.getSession(true);
	    Long creationtime = session.getCreationTime();
	    String sessionId = session.getId();
	    //after 20 seconds it generates a new sessionId
	    session.setMaxInactiveInterval(20);;
	    pw.println("<html> <head></head>");
		pw.println("<body>");
		pw.println("<h1>Hello World</h1>");
		
		pw.println(request.getParameter("type"));
		
		writeSessionInfo(pw, session);
		pw.println("</body></html>");
		//response.sendRedirect("http://www.google.it");
		
		//if type's value is CHANGE, then a new servlet is invoked
		String type_requested = request.getParameter("type");
		if(type_requested != null && type_requested.equals("CHANGE"))
		{
			request.getRequestDispatcher("DispatchedServlet").forward(request, response);
		} else if(type_requested != null && type_requested.equals("GOOGLE")){
			response.sendRedirect("http://www.google.it");
		}
			
		
	}
	
	private void writeSessionInfo(PrintWriter pw, HttpSession session) {
		// TODO Auto-generated method stub
		pw.println("<p> SessionId: "+session.getId()+"</p>");
		pw.println("<p> Creation Time: "+writeDate(session.getCreationTime())+"</p>");
		pw.println("<p> Last Accessed Time: "+writeDate(session.getLastAccessedTime())+"</p>");		
	}

	private String writeDate(long longDate) {
		// TODO Auto-generated method stub
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
		Date date = new Date(longDate);
		
		return formatter.format(date);
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
