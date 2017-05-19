package servlets;


import java.io.IOException;

import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accounts.AccountService;
import accounts.UserProfile;
/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private final AccountService accountService;
	   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet(AccountService accountService) {
        super();
        this.accountService = accountService;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		UserProfile user = accountService.getUserByLogin(login);
	//	java.util.logging.Logger.getLogger("My Logger").info("signin post with login:" + login + " password:" + pass);

		 if (login == null || pass == null) {
	            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            response.getWriter().println("Unauthorized");
	            return;
	        }

	        UserProfile profile = accountService.getUserByLogin(login);
	        if (profile == null /*|| !profile.getPass().equals(pass)*/) {
	            //response.setContentType("text/html;charset=utf-8");
	            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            response.getWriter().println("Unauthorized");
	            return;
	        }
	        
	        response.setStatus(HttpServletResponse.SC_OK);
	        response.getWriter().println("Authorized: "+login);
	    
	        return;
}
}
