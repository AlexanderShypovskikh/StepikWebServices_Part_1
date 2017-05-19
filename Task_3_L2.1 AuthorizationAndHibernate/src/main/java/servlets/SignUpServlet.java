package servlets;


import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accounts.AccountService;
import accounts.UserProfile;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final AccountService accountService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet(AccountService accountService) {
        super();
       this.accountService = accountService;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
	//	java.util.logging.Logger.getLogger("My Logger").info("signin post with login:" + login + " password:" + pass);
		HttpSession session  = request.getSession();
		UserProfile user = new UserProfile(login);
	    accountService.addNewUser(user);
	    accountService.addSession(session.getId(), user);
		
	
	}

}
