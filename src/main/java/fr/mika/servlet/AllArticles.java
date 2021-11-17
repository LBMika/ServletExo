package fr.mika.servlet;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.jakartaee.bcel.Const;

import fr.mika.model.Article;
import fr.mika.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/articles")
public class AllArticles extends HttpServlet {

	public AllArticles() {
		
	}
	
	@Override
	public void Init
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) request.getAttribute("user");
		if (user==null) {
			// Redirect
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/");
			return;
		}
		else {
			// Dispatch
		}
		
	}
	
	private List<Article> generateArticle() {
		List<Article> result;
		
		for (int i=0;i<10; i++) {
			Article a = new Article();
			
		}
		
		
		return result;
	}
}
