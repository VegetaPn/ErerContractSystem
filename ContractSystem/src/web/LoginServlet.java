package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import model.*;
import service.*;
import utils.APPException;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		  PrintWriter out=response.getWriter();
		  User account = new User();
		  UserService uservice=new UserService();
			String name=request.getParameter("form-username");
			String pwd1=request.getParameter("form-password");
			ResultSet rosters = uservice.getids();
			int id=-1;
			session.setAttribute("name", name);
			session.setAttribute("userid", id);
			session.setAttribute("rosters", rosters);

			if((id=uservice.login(name,pwd1))!=-1)//检测是否可以使用
			{ 
			String login_suc = "logsuccess.jsp";
			String login_1 = "pages/contract.jsp";
			String login_2 = "user.jsp";
			session.setAttribute("userid", id);
			//resp.sendRedirect(login_suc);
			
			session.setAttribute("userid", id);
			session.setAttribute("username", name);
			try {
				Role login_role=uservice.getUserRole(uservice.login(name, pwd1));
			System.out.println(login_role.getName());
			session.setAttribute("rolename", login_role.getName());
			session.setAttribute("roledesc", login_role.getDescription());
			if(login_role.getName().equals("admin"))
			{
				response.sendRedirect(login_1);
				return;
			}
			else //if(login_role.getName().equals("operator"))
			{
				response.sendRedirect("logsuccess.jsp");
				return;
			}
			} catch (APPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
			
			}
		
			response.sendRedirect("failed2.jsp");
		    return;
	   }
	
	   

}
