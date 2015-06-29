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
		 String username=(String) session.getAttribute("username");//��ȡ�û���
		 int userid= (int) session.getAttribute("userid");//��ȡ�û�id
		  PrintWriter out=response.getWriter();
		  //������Ҫ��ǩ�ĺ�ͬ���ָ��������Ȳ�ѯ���ݿ⡣�����ؿ��Ի�ǩ���б�ʹ��out.println()��ҳ��
		  
		  //User account = new User();
		  //UserService uservice=new UserService();//��û�ǩ��Ϣ
		 
		  String ContractN= request.getParameter("ContractN");
		  String CunName = request.getParameter("CunName");
		  String BTime = request.getParameter("BTime");
		  String ETime = request.getParameter("ETime");
		  String path=request.getParameter("AFile");
		  System.out.println(ETime);
		  String text= request.getParameter("text1");
		 //System.out.println("wocaonima "+ContractN+CunName+path);
		 // DateFormat df = new SimpleDateFormat("MM/dd/yyyy");//����Ϊ��Ҫ��ʽ��ʱ�����ڵ�ģʽ
		  try{
		 // Date Bt = df.parse(BTime);//���ַ������ն����ģʽת��ΪDate����
		// Date Et=df.parse(ETime);
		 
		  if((ContractN!= null)&&(CunName!=null)&&(BTime!=null)&&(ETime!=null)) {// ����Ƿ�Ϊ��
		   
		   //����Ϣ��ӽ����ݿ���
			  System.out.println("a");
			  DraftDao.add(path, ContractN, BTime, ETime, text, CunName,userid);
			  //out.print("<script> alert('�����ɹ�')</script>");
			  response.sendRedirect("contract.jsp"); 
			  return;
		   }

		 }
		 catch(Exception e)
		 {
			 
		 }
		}
	}


