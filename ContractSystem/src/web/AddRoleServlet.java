package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RoleService;
import model.Role;

/**
 * Servlet implementation class AddRoleServlet
 */
@WebServlet("/AddRoleServlet")
public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		RoleService rs = new RoleService();
		String rName, rDesc, rFuncId, tmp;
		String[] rFuncNameArrayStrings = {"QCHT","DGHT","CXHT","SCHT","HQHT","SPHT","QDHT",
				"FPHQ","FPSP","FPQD","LCCX","XZYH","BJYH","CXYH","SCYH","XZJS","BJJS","CXJS",
				"SCJS","XZGN","BJGN","CXGN","SCGN","PZQX","XZKH","BJKH","CXKH","SCKH","CXRZ",
				"SCRZ"};
		String[] sp = {",",",",",",",",",",",",",",",",",",",",",",",",",",",",",",
				",",",",",",",",",",",",",",",",",",",",",",",",",",",",""};
		rFuncId = "";
		rName = request.getParameter("newrolename");
		rDesc = request.getParameter("newroledesc");
		
		for (int i = 0; i < 30; i++) {
			tmp = request.getParameter(rFuncNameArrayStrings[i]);
			if(tmp != null) {
				rFuncId = rFuncId + tmp + sp[i];
			}
		}
		
		Role newRole = new Role();
		newRole.setName(rName);
		newRole.setDescription(rDesc);
		newRole.setFunction_id(rFuncId);
		newRole.setDel(0);
		
		rs.addaRole(newRole);
		
		response.sendRedirect("logsuccess.jsp");
	}
}
