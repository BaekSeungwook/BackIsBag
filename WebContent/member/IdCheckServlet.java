package kosta.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.member.model.dao.MemberDAO;
import kosta.member.model.dao.MemberDAOImpl;


/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/idCheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html;charset=UTF-8");
	      String id = request.getParameter("id");
	      String str = "";
	      MemberDAO dao = new MemberDAOImpl();
	      boolean result=false;
		try {
			result = dao.memberIdCheck(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      if(!result) {
	         str="<b style='color:green'>사용 가능한 아이디입니다</b>";
	      } else {
	         str="아이디가 중복입니다";
	      }
	      PrintWriter out = response.getWriter();
	      out.println(str);
	   }

}


