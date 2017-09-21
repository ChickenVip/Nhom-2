package bt2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Add() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		if(a==null||a.trim().length()==0||b==null||b.trim().length()==0)
		{
			response.sendRedirect("Interface.html");
			return;
		}
		int sum = Integer.parseInt(a) + Integer.parseInt(b);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Add</title></head><body>");
		out.println("<p>the sum of"+a+" and " + b + "is" + sum + ".</p>");
		out.println("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
