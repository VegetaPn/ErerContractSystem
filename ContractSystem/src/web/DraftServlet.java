package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DraftDao;

import java.sql.*;

import model.*;
import service.*;
import utils.*;
/**
 * Servlet implementation class DraftServlet
 */
@WebServlet("/DraftServlet")
public class DraftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		 String username=(String) session.getAttribute("username");//获取用户名
		 int userid= (int) session.getAttribute("userid");//获取用户id
		  PrintWriter out=response.getWriter();
		  //返回需要会签的合同名字给下拉框，先查询数据库。。返回可以会签的列表。使用out.println()给页面
		  
		  //User account = new User();
		  //UserService uservice=new UserService();//获得会签信息
		 
		  String ContractN= request.getParameter("ContractN");
		  String CunName = request.getParameter("CunName");
		  String BTime = request.getParameter("BTime");
		  String ETime = request.getParameter("ETime");
		  String path=request.getParameter("AFile");
		  System.out.println(ETime);
		  String text= request.getParameter("text1");
		 //System.out.println("wocaonima "+ContractN+CunName+path);
		 // DateFormat df = new SimpleDateFormat("MM/dd/yyyy");//参数为你要格式化时间日期的模式
		  try{
		 // Date Bt = df.parse(BTime);//将字符串按照定义的模式转换为Date对象
		// Date Et=df.parse(ETime);
		 
		  if((ContractN!= null)&&(CunName!=null)&&(BTime!=null)&&(ETime!=null)) {// 检查是否为空
		   
		   //把信息添加进数据库中
			  System.out.println("a");
			  DraftDao.add(path, ContractN, BTime, ETime, text, CunName,userid);
			  //out.print("<script> alert('操作成功')</script>");
			  response.sendRedirect("contract.jsp"); 
			  return;
		   }

		 }
		 catch(Exception e)
		 {
			 
		 }
		}
	}


