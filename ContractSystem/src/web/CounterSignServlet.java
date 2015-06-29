package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Contract;
import dao.ContractDao;
import dao.CounterSignDao;

/**
 * Servlet implementation class CounterSignServlet
 */
@WebServlet("/CounterSignServlet")
public class CounterSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterSignServlet() {
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
		ArrayList<Contract> list=new ArrayList<Contract>();
		ArrayList<Contract> list1=new ArrayList<Contract>();//接受已会签合同
		ArrayList<Integer> list3=new ArrayList<Integer>();//查看状态
		String type=request.getParameter("type");
		HttpSession session = request.getSession();
		int userid= (int) session.getAttribute("userid");//获取用户id
		if(type.equals("before")){//是从主页面传过来的参数
			if(!CounterSignDao.counterSignRight(userid)){//没有会签权限的时候
				response.sendRedirect("noright.jsp");
			}else{//有会签权限
				try {
					list=CounterSignDao.hqContract(userid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("hqcon", list);
				RequestDispatcher rd=request.getRequestDispatcher("countersign.jsp");
			    rd.forward(request,response);
				
			}
		}else if(type.equals("detail")){
			String conid=request.getParameter("id");
			String conname=request.getParameter("conname");
			String time=request.getParameter("time");
			request.setAttribute("conname",conname);
			request.setAttribute("conid",conid);
			request.setAttribute("time", time);
			RequestDispatcher rd=request.getRequestDispatcher("CounterSignDetail.jsp");
		    rd.forward(request,response);
		}else if(type.equals("hq")){//进行会签操作
			String conid=request.getParameter("id");
			String content=request.getParameter("text1");
			try {
				CounterSignDao.hq( userid, Integer.parseInt(conid),content);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("contract.jsp");
		}else if(type.equals("after")){//查看已会签的合同
			if(!CounterSignDao.counterSignRight(userid)){//没有会签权限的时候
				response.sendRedirect("noright.jsp");
			}else{//有会签权限
				
				try {
					
					list1=CounterSignDao.hqed(userid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<list1.size();i++)
				{
					int id1=list1.get(i).getId();
					try {
						list3.add(ContractDao.getStateByID(id1));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				request.setAttribute("hqed", list1);
				request.setAttribute("state",list3);
				RequestDispatcher rd=request.getRequestDispatcher("Countered.jsp");
			    rd.forward(request,response);
				
			}
			
		}
	}

}
