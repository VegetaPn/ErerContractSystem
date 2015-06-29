package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.websocket.Session;

import model.*;
import utils.APPException;
import utils.DBUtil;

public class UserDao {
	public static boolean isExist(String  name){
	Connection con = null;
	try {
		con = DBUtil.getConnection();
	} catch (APPException e1) {
		// TODO Auto-generated catch block
		
		e1.printStackTrace();
	}
	Statement st = null;
	try {
		st = (Statement)con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String sql="select * from t_user where name='"+name+"'";
	
    System.out.println(sql);
    
	
    
	ResultSet rs=null;
	boolean flag=false;
	try {
		rs = st.executeQuery(sql);
		
	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {
		
		flag=rs.next();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
		
	}
	public static void add(User new_user, String userfax) 
	{
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
		
		String sql="insert into t_user(name,password,del)values('"+new_user.getName()+"','"+new_user.getPassword()+"',"+new_user.getDel()+")";
		st.execute(sql);
		String sql_s="select id from t_user where name='"+ new_user.getName()+"' ";
		ResultSet rs =st.executeQuery(sql_s);
		rs.next();
		String sql2="insert into t_right(user_id,role_id,del)values('"+rs.getInt("id")+"','"+"2"+"','"+new_user.getDel()+"')";
		System.out.println(sql2);
		String sql3="insert into t_customer(num,name,address,tel,fax,code,bank,account,del)values('"+rs.getString("id")+"','"+"-"+"','"+"-"+"','"+
					"-"+"','"+userfax+"','"+"-"+"','"+"-"+"','"+"-"+"',"+new_user.getDel()+")";
		st.execute(sql2);
		System.out.println(sql3);
		st.execute(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	public static int login(String name, String password) throws SQLException  
{
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		
			try {
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String sql="select id,password from t_user where name='"+name+"'";
		ResultSet rs = null;
		
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.next();
		
			if(password.equals(rs.getString("password")))
			{
				return rs.getInt("id");
				}
			else
				return -1;
		
		
		

}
	
	public static ResultSet getallids(){
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select id from t_user";
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String[] getallUserNames() {
		int countofNames = 0, count = 0;
		String[] allNames = null;
		ResultSet allids = getallids();
		
		try {
			allids.last();
			countofNames = allids.getRow();
			allids.beforeFirst();
			
			allNames = new String[countofNames];
			
			while (allids.next()) {
				allNames[count] = getNamebyID(allids.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allNames;
	}
	
	public static String getNameByID(int id) throws SQLException{
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		
			try {
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String sql="select name from t_user where id="+id;
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.next();
		
		return rs.getString("name");
	}
	
	public static String getNamebyID(String id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "select name from t_user where id='"+ id +"' ";
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getUseridbyName(String uname) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "select id from t_user where name='"+ uname +"' ";
			System.out.println(sql);
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static User getUserByName(String name) throws SQLException{
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		
			try {
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String sql="select id from t_user where name='"+name+"'";
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.next();
		User user1=new User();
		user1.setId(rs.getInt("id"));
		user1.setName(name);
		return user1;
		
		
	}
	
	public static boolean updateName(String userid, String upName) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "update t_user set name = '"+upName+"' where id='"+ userid +"' ";
			System.out.println(sql);
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteUser(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String presql = "delete from t_right where user_id = " + id;
			String sql = "delete from t_user where id = "+id;
			System.out.println(sql);
			ResultSet prers = st.executeQuery(presql);
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
		
