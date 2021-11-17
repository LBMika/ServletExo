package fr.mika.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@WebFilter(urlPatterns = { "/accueil.jsp" })
public class LoginFilter implements Filter{
	private List<User> users;

	public LoginFilter() {
	}
	
	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		System.out.println("Login filter init !");
		
		// User list
		users = new ArrayList<User>();
		User user = new User("toto", "toto@lebest.com", "user");
		users.add(user);
		user = new User("titi", "titi@yahoo.com", "user");
		users.add(user);
		user = new User("tata", "tata@gmail.com", "user");
		users.add(user);
		user = new User("super", "admin@monsite.com", "admin");
		users.add(user);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		

		HttpServletRequest request = (HttpServletRequest) req;
		// Get user parameter
		String username =  req.getParameter("nom");
		
		System.out.println("Je suis là Login Filter");
		
		// If user not found -> 404
		if (username==null) {
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect(request.getContextPath()+"/index.html");
			return;
		}
		User user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
		if (user==null) {
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect(request.getContextPath()+"/index.html");
			return;
		}
		
		// Session
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		// If user admin -> admin page
		if (user.getRole().equals("admin")) {
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect(request.getContextPath()+"/admin.html");
			return;
		}
		
		// Otherwise -> accueil page
		chain.doFilter(req, res);
	}
	
	@Override
	public void destroy() {
		System.out.println("Login filter destroy!");
	}

}
