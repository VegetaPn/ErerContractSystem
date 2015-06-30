package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttachDao;

/**
 * Servlet implementation class DownLoadServlet
 */
@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		OutputStream o=response.getOutputStream();
	    byte b[]=new byte[1024];
	    //the file to download.
	    File fileLoad = null;
		try {
			fileLoad = new File("d:/xyk0058/"+name+"/",AttachDao.getPathByName(name));
		    //the dialogbox of download file.
		    response.setHeader("Content-disposition",
		    "attachment;filename="+AttachDao.getPathByName(name));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //set the MIME type.
	    response.setContentType("application/x-tar");
	    //get the file length.
	    long fileLength=fileLoad.length();
	    String length=String.valueOf(fileLength);
	    response.setHeader("Content_Length",length);
	    //download the file.
	    FileInputStream in=new FileInputStream(fileLoad);
	    int n=0;
	    while((n=in.read(b))!=-1){
	     o.write(b,0,n);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
