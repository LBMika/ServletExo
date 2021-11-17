package fr.mika.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
	List<Article> articles;

	public AllArticles() {
		articles = new ArrayList<Article>();
	}
	
	@Override
	public void init() {
		articles.clear();
		this.generateArticle();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		request.setAttribute("articles", articles);
		
		request.getRequestDispatcher("/articles.jsp").forward(request, response);
	}
	
	private void generateArticle() {
		String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi. Proin porttitor, orci nec nonummy molestie, enim est eleifend mi, non fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa, scelerisque vitae, consequat in, pretium a, enim. Pellentesque congue. Ut in risus volutpat libero pharetra tempor. Cras vestibulum bibendum augue. Praesent egestas leo in pede. Praesent blandit odio eu enim. Pellentesque sed dui ut augue blandit sodales. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam nibh. Mauris ac mauris sed pede pellentesque fermentum. Maecenas adipiscing ante non diam sodales hendrerit. ";
		for (int i=0;i<5; i++) {
			Article a = new Article();
			a.setTitre("Titre de l'article "+i);
			a.setUser("User "+i);
			a.setContenu(s);
			articles.add(a);
		}
	}
}
