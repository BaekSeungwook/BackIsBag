package kosta.bag;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;

@WebServlet(urlPatterns="/product") //경로이름지정!!!
public class DispatcherServlet extends HttpServlet {
	
	Map<String, Controller> map;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		map =(Map<String, Controller>)application.getAttribute("map");	
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("command");
		if(key==null) key="productlist";//list는 전체검색(목록).
		//검색, 수정, 등록
		map.get(key);
		Controller controller = map.get(key);
		
		ModelAndView mv = controller.handleRequest(request, response);
		if(mv.isRedirect()) {// true이므로 redirect로 이동
			response.sendRedirect(mv.getPath());
		} else {
			request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
	}
}
