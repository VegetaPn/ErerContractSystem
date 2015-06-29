package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
//private String url="jdbc:mysql://127.0.0.1:3306/contractda?useunicode";
	public static String url = "jdbc:oracle:thin:@172.31.34.13:1521:orcl";
	public static String user = "contractor"; // 用户名
	public static String password = "con"; //密码 
	static{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");  //隐式注册
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	}  
	public static Connection getConnection() throws  APPException
	{
		Connection con=null;
		try{ 
			
		con = DriverManager.getConnection(url,user,password);
		
		}
		
	catch( Exception e)
	{
		throw new APPException("utils.DBUtil.getconnection");
	}
	return con;
	}
	
	
	
	
	
	
	
	public static void closeConnection(Connection con) throws  APPException
	{try{
		if(con!=null&&!con.isClosed()){
		con.close();
		con=null;}
	}
	catch(Exception e){
		throw new APPException("utils.DBUtil.closeConnection");
		
	}
	}
	public static void closeStatement(Statement st)throws  APPException
	{
		try{if(st!=null&&!st.isClosed()){
			st.close();
		st=null;}
	
		
	}catch(Exception e)
	{throw new APPException("utils.DBUtil.closeStatement");
		}
	}
	
	
	
	public static void closeresultset(ResultSet re)throws  APPException
	{try{
		if(re!=null&&!re.isClosed())
		{re.close();
	
	    re=null;}
		
	}catch(Exception e)
	{
		throw new APPException("utils.DBUtil.closeStatement");
		
	}
	}
	
	
	
}
