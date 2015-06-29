package web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DraftDao;
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
		  
		  
		  try{
			  	
				 //use sessionid to create a temp file.
				 String tempFileName=(String)session.getId();
				 //create the temp file.
				 File temp=new File("d:/xyk0058/",tempFileName);
				 File parent = temp.getParentFile();
				 if(parent!=null && !parent.exists()){ 
					 parent.mkdirs();
				 }
				 FileOutputStream o=new FileOutputStream(temp);
				 if(request.getContentLength()>297){
				   //write the upload content to the temp file.
				   InputStream in=request.getInputStream();
				   byte b[]=new byte[1024];
				   int n;
				   while((n=in.read(b))!=-1){
				    o.write(b,0,n);
				   }
				   o.close();
				   in.close();
				   //read the temp file.
				   RandomAccessFile random=new RandomAccessFile(temp,"r");
				   //read Line2 to find the name of the upload file.
				   int second=1;
				   String secondLine=null;
				   
				   for(int i=1;i<=3;i++){
					   secondLine=random.readLine();
				   }
				   ContractN = random.readLine();
				   for(int i=1;i<=3;i++){
					   secondLine=random.readLine();
				   }
				   CunName = random.readLine();
				   for(int i=1;i<=3;i++){
					   secondLine=random.readLine();
				   }
				   BTime = random.readLine();
				   for(int i=1;i<=3;i++){
					   secondLine=random.readLine();
				   }
				   ETime = random.readLine();
				   for(int i=1;i<=3;i++){
					   secondLine=random.readLine();
				   }
				   text = random.readLine();
				   
				   random.seek(0);
				   while(second<=22){
					    secondLine=random.readLine();
					    second++;
				   }
				   //get the last location of the dir char.'//'.
				   int position=secondLine.lastIndexOf("filename");
				   //get the name of the upload file.
				   String fileName=secondLine.substring(position+10,secondLine.length()-1);
				   System.out.print("filename:"+fileName);
				   //relocate to the head of file.
				   random.seek(0);
				   //get the location of the char.'Enter' in Line4.
				   long forthEndPosition=0;
				   int forth=1;
				   while((n=random.readByte())!=-1&&(forth<=24)){
				    if(n=='\n'){
				     forthEndPosition=random.getFilePointer();
				     forth++;
				    }
				   }
				   System.out.println("ContacrN:"+ContractN);
				   File realFile=new File("d:/xyk0058/"+ContractN+"/",fileName);
				   parent = realFile.getParentFile();
					 if(parent!=null && !parent.exists()){ 
						 parent.mkdirs();
					 }
				   RandomAccessFile random2=new RandomAccessFile(realFile,"rw");
				   //locate the end position of the content.Count backwards 6 lines.
				   random.seek(random.length());
				   long endPosition=random.getFilePointer();
				   long mark=endPosition;
				   int j=1;
				   while((mark>=0)&&(j<=6)){
				    mark--;
				    random.seek(mark);
				    n=random.readByte();
				    if(n=='\n'){
				     endPosition=random.getFilePointer();
				     j++;
				    }
				   }
				   //locate to the begin of content.Count for 4 lines's end position.
				   random.seek(forthEndPosition);
				   long startPoint=random.getFilePointer();
				   //read the real content and write it to the realFile.
				   while(startPoint<endPosition-1){
				    n=random.readByte();
				    random2.write(n);
				    startPoint=random.getFilePointer();
				   }
				   random2.close();
				   random.close();
				   //delete the temp file.
				   temp.delete();
				   System.out.print("File upload success!");
				 }
				 else{
					 System.out.print("No file!");
				 }
				}
				catch(IOException e){
				 System.out.print("upload error.");
				 e.printStackTrace();
				}
		  
		  
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


