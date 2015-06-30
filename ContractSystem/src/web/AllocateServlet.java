package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import service.*;
import utils.APPException;
import dao.*;
/**
 * Servlet implementation class AllocateServlet
 */
@WebServlet("/AllocateServlet")
public class AllocateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		 PrintWriter out=response.getWriter();
		ArrayList<Contract> list=new ArrayList<Contract>();
		ArrayList<String> names=new ArrayList<String>();//�û�������
		ArrayList<User> conter=new ArrayList<User>();//�����л�ǩȨ�޵��û�
		ArrayList<User> approve=new ArrayList<User>();//���������Ȩ�޵��û�
		ArrayList<User> sign=new ArrayList<User>();//������ǩ��Ȩ�޵��û�
		
		if(type.equals("before")){//�Ǵ���ҳ�洫�����Ĳ���
			list= AssignDao.assignList();
			//System.out.println("0");
			
			if(list!=null){
				for(int i=0;i<list.size();i++){
					try {
						names.add(UserDao.getNameByID(((Contract)list.get(i)).getUseId()));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				request.setAttribute("contracts", list);
				request.setAttribute("names", names);
				RequestDispatcher rd=request.getRequestDispatcher("allocation.jsp");
			    rd.forward(request,response);
		}
		
	}else if(type.equals("detail")){//�������ҳ��
		String id=request.getParameter("id");
		String conname=request.getParameter("conname");
		try {
			conter=CounterSignDao.userList();
			approve=ApproveDao.userList();
			sign=SignedDao.userList();
			
		} catch (APPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("couterlist", conter);
		request.setAttribute("approvelist", approve);
		request.setAttribute("signlist", sign);
		request.setAttribute("conname", conname);
		request.setAttribute("conid",id );
		RequestDispatcher rd=request.getRequestDispatcher("AllocateDetail.jsp");
	    rd.forward(request,response);
		
	}else if(type.equals("allocate")){//�ύ�б�����ݿ����
		
		String id1=request.getParameter("cid");
		
		//String hqname=request.getParameter("hqright");
		String[] hqname=request.getParameterValues("hqright");
		String[] spname=request.getParameterValues("spright");
		String[] qdname=request.getParameterValues("qdright");
		for(int i=0;i<hqname.length;i++){
			User hquser=new User();
			try {
				hquser=UserDao.getUserByName(hqname[i]);
				System.out.println(hqname[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AssignDao.assignhq(Integer.parseInt(id1), hquser.getId(),hqname.length);
			
		}
		
		for(int i=0;i<spname.length;i++){
			User spuser=new User();
			try {
				spuser=UserDao.getUserByName(spname[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AssignDao.assignsp(Integer.parseInt(id1), spuser.getId(),spname.length);
		}
		
		for(int i=0;i<qdname.length;i++){
			User qduser=new User();
			try {
				qduser=UserDao.getUserByName(qdname[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AssignDao.assignqd(Integer.parseInt(id1), qduser.getId(),qdname.length);
		}
		//�������,֮��֪ͨ��һ���Ļ�ǩ��
		response.sendRedirect("AllocateServlet?type=before");
	}
		//out.print("<script> alert('�����ɹ�')</script>");
		
}
}
