package kosta.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.bag.Controller;

@WebListener //리스너는 서버가 시작될때 자동호출됨
public class HandlerMappingListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  {}

    public void contextInitialized(ServletContextEvent e)  { 
        //서버가 start될 때 사용될 객체를 생성해서 Map에 저장
    	Map<String, Controller> map = new HashMap<>();
    	//1. properties파일 로딩(ResourceBundle는 properties를 
    	//불러오는 전용객체이므로 확장자를 굳이 안불러도됨)
    	ServletContext application = e.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	System.out.println("fileName : "+fileName);
    	ResourceBundle rb = ResourceBundle.getBundle("kosta/listener/ActionMapping");
    	//2. key와 value를 분히라면서 value를 객체로만들어 Map에저장
    	Iterator<String> it = rb.keySet().iterator();
    	while(it.hasNext()) {
    		String key = it.next();
    		String value = rb.getString(key);
    		
    		try {
	    		//문자열을 객체로 변환
	    		Controller classObj = (Controller)Class.forName(value).newInstance();
	    		System.out.println(classObj);
	    		map.put(key, classObj);
    		} catch (Exception ex) {
				ex.printStackTrace();
			}
    	}//while end
    	
    	application.setAttribute("map", map);
    }
	
}
