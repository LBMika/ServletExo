package fr.mika.servlet;

import java.io.IOException;

import org.apache.tomcat.jakartaee.bcel.Const;

import fr.mika.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/infouser")
public class InfoUser extends HttpServlet {

	public InfoUser() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
	
		request.setAttribute("username", user.getUsername());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("nbArticles", user.getArticles().size());
		request.getRequestDispatcher("/infouser.jsp").forward(request, response);
	}
}
