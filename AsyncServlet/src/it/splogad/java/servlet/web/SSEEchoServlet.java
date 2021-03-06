package it.splogad.java.servlet.web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SSEEchoServlet
 */
@WebServlet(urlPatterns={"/simplesse"})
public class SSEEchoServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        // set content type
        res.setContentType("text/event-stream");
        res.setCharacterEncoding("UTF-8");

        String msg = req.getParameter("msg");

        PrintWriter writer = res.getWriter();

        // send SSE
        writer.write("data: " + msg + "\n\n");
    }
}