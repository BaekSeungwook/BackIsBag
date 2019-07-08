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

@WebListener //�����ʴ� ������ ���۵ɶ� �ڵ�ȣ���
public class HandlerMappingListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  {}

    public void contextInitialized(ServletContextEvent e)  { 
        //������ start�� �� ���� ��ü�� �����ؼ� Map�� ����
    	Map<String, Controller> map = new HashMap<>();
    	//1. properties���� �ε�(ResourceBundle�� properties�� 
    	//�ҷ����� ���밴ü�̹Ƿ� Ȯ���ڸ� ���� �Ⱥҷ�����)
    	ServletContext application = e.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	System.out.println("fileName : "+fileName);
    	ResourceBundle rb = ResourceBundle.getBundle("kosta/listener/ActionMapping");
    	//2. key�� value�� ������鼭 value�� ��ü�θ���� Map������
    	Iterator<String> it = rb.keySet().iterator();
    	while(it.hasNext()) {
    		String key = it.next();
    		String value = rb.getString(key);
    		
    		try {
	    		//���ڿ��� ��ü�� ��ȯ
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
