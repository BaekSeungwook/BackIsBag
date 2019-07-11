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

@WebServlet(urlPatterns="/product") //����̸�����!!!
public class DispatcherServlet extends HttpServlet {
	
	Map<String, Controller> map;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		map =(Map<String, Controller>)application.getAttribute("map");	
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("command");
		if(key==null) key="productlist";//list�� ��ü�˻�(���).
		//�˻�, ����, ���
		map.get(key);
		Controller controller = map.get(key);
		
		ModelAndView mv = controller.handleRequest(request, response);
		if(mv.isRedirect()) {// true�̹Ƿ� redirect�� �̵�
			response.sendRedirect(mv.getPath());
		} else {
			request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
	}
}
