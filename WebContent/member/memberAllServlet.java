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



@WebServlet("/memberAll") //서블릿 등록 (자동완성)
public class selectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//넘어오는 값 받기
		//service -> dao -> 그 결과를 받아서 결과뷰로 이동
		MemberDAO dao = new MemberDAOImpl();
		List<MemberDTO> list = null;
		try {
			list = dao.memberAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//뷰쪽으로 전달될 데이터를 scope 영역에 저장
		request.setAttribute("list", list); //뷰에서 ${requestScope.list}
		
		//이동하기
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
