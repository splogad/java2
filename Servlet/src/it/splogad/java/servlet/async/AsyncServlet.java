//package it.splogad.java.servlet.async;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.concurrent.ScheduledThreadPoolExecutor;
//
//import javax.servlet.AsyncContext;
//import javax.servlet.AsyncEvent;
//import javax.servlet.AsyncListener;
//import javax.servlet.ServletException;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class AsyncServlet
// */
//@WebServlet(urlPatterns="/AsyncServlet", asyncSupported=true)
//public class AsyncServlet extends HttpServlet {
//	
//	private static final long serialVersionUID = 1L;
//    private AsyncContext ac;
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AsyncServlet(AsyncContext ac) {
//    	super();
//        // TODO Auto-generated constructor stub
//    }
//    
//    public void init(){
//    	
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	
//		
//		AsyncContext ac = request.startAsync();
//		ac.addListener(new AsyncListener(){
//			public void onComplete(AsyncEvent event)
//			throws IOException{
//				
//				System.out.println("<p>Instance Completed</p>");
//			}
//
//			@Override
//			public void onError(AsyncEvent arg0) throws IOException {
//				// TODO Auto-generated method stub
//				
//				System.out.println("<p>Instance in error</p>");
//			}
//
//			@Override
//			public void onStartAsync(AsyncEvent arg0) throws IOException {
//				// TODO Auto-generated method stub
//				System.out.println("<p>Instance Started</p>");
//			}
//
//			@Override
//			public void onTimeout(AsyncEvent arg0) throws IOException {
//				// TODO Auto-generated method stub
//				System.out.println("<p>Instance is timeout</p>");
//			}
//		});
//		
//		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(10);
//		exec.execute(new MyAsyncService(ac));
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//}
