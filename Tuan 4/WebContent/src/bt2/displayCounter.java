package bt2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayCounter")
public class displayCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public displayCounter() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sever = getServletContext();
		
		//get counter
		Integer counter = (Integer)getServletContext().getAttribute("counter");

		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("<html><head><title>Display Counter</title></head><body>");
		out.println("<h2>You are visitor number #" + counter + "</h2>.");
		out.println("</body></html>");
	}

}
