package kosta.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;
import kosta.member.model.dto.MemberDTO;
import kosta.member.model.service.MemberService;

public class LoginController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      ModelAndView mv = new ModelAndView();
      mv.setPath("member/memberLoginForm.jsp");
      
      String memberId = request.getParameter("memberId");
      String memberPass = request.getParameter("memberPass");
      try {
         //

         MemberDTO login = MemberService.memberId(memberId);
         
         if(memberPass.equals(login.getMemberPass())) {
        	HttpSession session = request.getSession();
        	session.setAttribute("login", login);            
            mv.setPath("index.jsp");
            return mv;
         }else {
            request.setAttribute("message", "Invalid ID or password.");//jsp문서에서 표현언(EL) 이용해서 ${requestScope.message}
            return mv;
         }       
      }catch (Exception e) {
         e.printStackTrace();
      }
      return mv;
   }
}