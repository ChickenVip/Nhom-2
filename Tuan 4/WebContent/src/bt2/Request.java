package bt2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Request",loadOnStartup=1)
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int counter;
    public Request() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		counter = 0;
		getServletContext().setAttribute("counter", counter);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sever = getServletContext();
		
		//get counter
		Integer counter = (Integer)getServletContext().getAttribute("counter");
		//increment counter
		counter++;
		// set counter to application scope
		sever.setAttribute("counter", counter);
		
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("<html><head><title>Request Counter</title></head><body>");
		out.println("<h2>You are visitor #" + counter +  "</h2>.");
		out.println("</body></html>");
	}

}
