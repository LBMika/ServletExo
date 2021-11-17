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
@WebFilter("/article.jsp")
public class ArticleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ArticleFilter() {
        
    }
    
    @Override
	public void init(FilterConfig fconfig) throws ServletException {
		System.out.println("Article filter init");
	}


    @Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		User user =  (User) session.getAttribute("user");
		

		System.out.println("Je suis là Article Filter");
		
		if (user==null) {
			response.sendRedirect(request.getContextPath()+"/index.html");
			return;
		}
		
		chain.doFilter(req, res);
	}
	

	@Override
	public void destroy() {
		System.out.println("Article filter destroy!");
	}

}
