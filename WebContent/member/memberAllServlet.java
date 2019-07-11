package kosta.member.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.member.model.dao.MemberDAO;
import kosta.member.model.dao.MemberDAOImpl;
import kosta.member.model.dto.MemberDTO;



@WebServlet("/memberAll") //���� ��� (�ڵ��ϼ�)
public class selectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�Ѿ���� �� �ޱ�
		//service -> dao -> �� ����� �޾Ƽ� ������ �̵�
		MemberDAO dao = new MemberDAOImpl();
		List<MemberDTO> list = null;
		try {
			list = dao.memberAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//�������� ���޵� �����͸� scope ������ ����
		request.setAttribute("list", list); //�信�� ${requestScope.list}
		
		//�̵��ϱ�
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
