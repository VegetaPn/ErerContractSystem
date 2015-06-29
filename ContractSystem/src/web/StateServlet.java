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

/**
 * Servlet implementation class StateServlet
 */
@WebServlet("/StateServlet")
public class StateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateServlet() {
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
		
		ArrayList<Integer> list3=new ArrayList<Integer>();//返回状态
		
		String type=request.getParameter("type");
		HttpSession session = request.getSession();
		int userid= (int) session.getAttribute("userid");//获取用户id
		if(type.equals("before")){//是从主页面传过来的参数
			
				try {
					list=ContractDao.getAllContracts(userid);
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
				RequestDispatcher rd=request.getRequestDispatcher("State.jsp");
			    rd.forward(request,response);
				
			
		
		}
	}
}


