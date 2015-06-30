package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import model.*;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	  Customer customer = new Customer();
	  UserService uservice=new UserService();
	
	String page;
		String name=request.getParameter("form-username");
		String pwd1=request.getParameter("form-password");
		String pwd2=request.getParameter("form-password2");
		String email = request.getParameter("form-email");
		
		 if((name.length()>=4&&name.length()<=20)&&(pwd1.length()>=6&&pwd1.length()<=12)&&(pwd2.equals(pwd1))){
			
			 System.out.println("success");
			    account.setPassword(pwd1);
			    account.setName(name);
			    customer.setFax(email);
			    session.setAttribute("User", account);
			    try {
					if(uservice.register(account, email))//检测是否可以使用
					{
					String login_suc = "resucess.jsp";
					
					response.sendRedirect(login_suc);
					return;
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			   }
			  
			 String login_fail = "Failed.jsp";
			 response.sendRedirect(login_fail);
			  return;
           
           
		 }
		
		 
		 
	}


