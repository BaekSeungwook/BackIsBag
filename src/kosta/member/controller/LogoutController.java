package kosta.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.bag.Controller;
import kosta.bag.ModelAndView;

public class LogoutController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
         ModelAndView mv = new ModelAndView();
         String url = null;
         HttpSession session = request.getSession();
         try {
           session.invalidate();
           url = "/index.jsp";
         } catch(Exception e) {
            e.printStackTrace();
           
         }
         mv.setPath(url);
      return mv;
   }

}