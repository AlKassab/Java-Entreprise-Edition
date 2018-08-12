package tn.esprit.IRMCJEE.presentation.mbeans;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/user1/*")
public class FilterLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override 
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain filter)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		
		LoginBean loginbean = (LoginBean) request.getSession().getAttribute("loginBean");
		
		if (loginbean != null && loginbean.getU() != null) {
			filter.doFilter(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Login.jsf");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
