package ex0701.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0701.dao.MemberDAO;
import ex0701.dao.MemberDAOImpl;
import ex0701.dto.MemberDTO;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String cellphone = request.getParameter("cellphone");
		String addr = request.getParameter("addr");
		String date = request.getParameter("date");
		String grade = request.getParameter("grade");
		String age = request.getParameter("age");
		
		//�Ѿ���� ��� �� �޾Ƽ� dto�� �����Ѵ�.
		MemberDTO dto = new MemberDTO(id, pass, name, email, cellphone, addr, date, grade, Integer.parseInt(age));
		//���� ���� ��ȿ�� üũ
		
		MemberDAO dao = new MemberDAOImpl();
		//if(dao.idCheck(id)) { //db
		//} else {
			//insert�� ȣ��
			//selectAll�� �̵��Ѵ�.
			//response.sendRedirect("selectAll");
		//}
		if(dao.idCheck(id)) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+id+" �� �̹� ��� ���Դϴ�.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			//insert�� ȣ��
			dao.insert(dto);
			response.sendRedirect("memberAll");
		}
	}

}
