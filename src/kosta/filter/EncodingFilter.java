package kosta.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodingFilter
 */
//필터를 web.xml에 등록하는대신 어노테이션으로 등록
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class EncodingFilter implements Filter {
	String encoding;
	public void destroy() {}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding=fConfig.getInitParameter("encoding");//encoding에 UTF-8이 담긴다
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding); //init에서 할당된 encoding요청
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
