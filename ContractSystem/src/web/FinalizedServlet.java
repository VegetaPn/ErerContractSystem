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

import dao.ContractDao;
import dao.FinalizedDao;
import dao.SendMailDao;
import model.ConProcess;
import model.Contract;

/**
 * Servlet implementation class FinalizedServlet
 */
@WebServlet("/FinalizedServlet")
public class FinalizedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizedServlet() {
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
		ArrayList<Contract> list=new ArrayList<Contract>();//返回待定稿合同
		ArrayList<Contract> list1=new ArrayList<Contract>();//返回已定稿
		ArrayList<Integer> list3=new ArrayList<Integer>();//返回状态
		ArrayList<Integer> list4=new ArrayList<Integer>();//返回已定稿
		String type=request.getParameter("type");
		HttpSession session = request.getSession();
		int userid= (int) session.getAttribute("userid");//获取用户id
		if(type.equals("before")){
			try {
				
				list=FinalizedDao.toBeFinalized(userid);
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
			request.setAttribute("final", list);
			request.setAttribute("state",list3);
			RequestDispatcher rd=request.getRequestDispatcher("Finalized.jsp");
		    rd.forward(request,response);
			
			
		}else if(type.equals("detail")){
			String content = request.getParameter("content");
			String time=request.getParameter("time");
			String conid=request.getParameter("id");
			String conname=request.getParameter("conname");
			request.setAttribute("content", content);
			request.setAttribute("time",time);
			request.setAttribute("conid",conid);
			request.setAttribute("conname",conname);
			RequestDispatcher rd=request.getRequestDispatcher("FinalizedDetail.jsp");
		    rd.forward(request,response);
			
		}else if(type.equals("update")){
			String newcontent=request.getParameter("text1");
			String conid=request.getParameter("id");
			try {
				FinalizedDao.updateContent(Integer.parseInt(conid), newcontent);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<String> spuser = null;
			try {
				spuser=ContractDao.getSpUser(Integer.parseInt(conid));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String mail = null;
			for(int e=0;e<spuser.size();e++){
				try {
					mail=ContractDao.getMailByName(spuser.get(e));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SendMailDao.send(mail, "尊敬的用户"+spuser.get(e)+"您有新消息了", "您有一份合同需要审批，请登录小二二管理系统进行审批");
			}
			response.sendRedirect("FinalizedServlet?type=before");
		}else if(type.equals("after")){
         try {
				
				list1=FinalizedDao.afterFinalized(userid);
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
			RequestDispatcher rd=request.getRequestDispatcher("FinaledAfter.jsp");
		    rd.forward(request,response);
			
		}
		
	}

}
