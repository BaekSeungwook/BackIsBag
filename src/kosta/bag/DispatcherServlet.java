package kosta.bag;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("") //경로이름지정!!!
public class DispatcherServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
