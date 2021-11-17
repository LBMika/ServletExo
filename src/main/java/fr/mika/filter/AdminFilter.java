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
@WebFilter("/admin.html")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        
    }
    
    @Override
	public void init(FilterConfig fconfig) throws ServletException {
		System.out.println("Admin filter init");
	}


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		User user =  (User) session.getAttribute("user");
		

		System.out.println("Je suis là Admin Filter");
		
		if (user==null || !user.getRole().equals("admin")) {
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect(request.getContextPath()+"/index.html");
			return;
		}
		
		chain.doFilter(req, res);
	}
	

	@Override
	public void destroy() {
		System.out.println("Admin filter destroy!");
	}

}
