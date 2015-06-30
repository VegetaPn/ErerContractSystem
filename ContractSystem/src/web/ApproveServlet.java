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
import dao.ApproveDao;
import dao.ContractDao;
import dao.CounterSignDao;
import dao.FinalizedDao;

/**
 * Servlet implementation class ApproveServlet
 */
@WebServlet("/ApproveServlet")
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveServlet() {
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
		ArrayList<Contract> list1=new ArrayList<Contract>();
		ArrayList<Integer> list3=new ArrayList<Integer>();//返回状态
		ArrayList<Integer> list4=new ArrayList<Integer>();//返回状态
		String type=request.getParameter("type");
		HttpSession session = request.getSession();
		int userid= (int) session.getAttribute("userid");//获取用户id
		if(type.equals("before")){//是从主页面传过来的参数
			if(!ApproveDao.approveRight(userid)){//没有会签权限的时候
				response.sendRedirect("noright.jsp");
			}else{//有审核权限
				try {
					list=ApproveDao.spContract(userid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<list.size();i++)
				{
					int id1=list.get(i).getId();
					try {
						list3.add(ContractDao.getStateByID(id1));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				request.setAttribute("spcon", list);
				request.setAttribute("state",list3);
				RequestDispatcher rd=request.getRequestDispatcher("Approve.jsp");
			    rd.forward(request,response);
				
			}
		}else if(type.equals("detail")){
			String conid=request.getParameter("id");
			String conname=request.getParameter("conname");
			String time=request.getParameter("time");
			String content=request.getParameter("content");
			request.setAttribute("conname",conname);
			request.setAttribute("conid",conid);
			request.setAttribute("time", time);
			request.setAttribute("content", content);
			RequestDispatcher rd=request.getRequestDispatcher("ApproveDetail.jsp");
		    rd.forward(request,response);
		}else if(type.equals("approve")){//进行审批
			String conid=request.getParameter("id");
			String content=request.getParameter("text2");
			String options=request.getParameter("optionsRadiosInline");
			try {
				ApproveDao.sp(options, userid, Integer.parseInt(conid),content);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("ApproveServlet?type=before");
			
		}else if(type.equals("after")){
			 try {
					
					list1=ApproveDao.sped(userid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<list1.size();i++)
				{
					int id1=list1.get(i).getId();
					try {
						list4.add(ContractDao.getStateByID(id1));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				request.setAttribute("final", list1);
				request.setAttribute("state",list4);
				RequestDispatcher rd=request.getRequestDispatcher("ApproveAfter.jsp");
			    rd.forward(request,response);
				
		}
	}

}
