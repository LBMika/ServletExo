package fr.mika.filter;

import java.io.IOException;

import fr.mika.model.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/infouser")
public class InfoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public InfoFilter() {
        
    }
    
    @Override
	public void init(FilterConfig fconfig) throws ServletException {
		System.out.println("Info filter init");
	}


    @Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		User user =  (User) session.getAttribute("user");
		

		System.out.println("Je suis là Info Filter");
		System.out.println("Info filter user = "+user);
		
		if (user==null) {
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect(request.getContextPath()+"/index.html");
			return;
		}
		
		chain.doFilter(req, res);
	}
	

	@Override
	public void destroy() {
		System.out.println("Info filter destroy!");
	}

}
