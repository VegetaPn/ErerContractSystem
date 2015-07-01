package dao;
import model.*;
import utils.*;

import java.sql.*;
public class RoleDao {
	public static Role getById(int id) throws APPException {
		// TODO Auto-generated method stub
		Role role=new Role();
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
		String presql = "select role_id from t_right where user_id="+id;
		int roleid=0;
		ResultSet prers = null;
		try {
			prers = st.executeQuery(presql);
			prers.next();
			roleid = prers.getInt("role_id");
		} catch(Exception e) {
			e.printStackTrace();
		}
		String sql="select del,id,description,function_ids,name  from t_role where id="+roleid;
		ResultSet rs=null;
		try{
		rs = st.executeQuery(sql);
		rs.next();
		role.setDel(rs.getInt("del"));
		role.setId(rs.getInt("id"));
		role.setFunction_id(rs.getString("function_ids"));
		role.setDescription(rs.getString("description"));
		role.setName(rs.getString("name"));
		}
		catch(Exception e)
		{
			throw new APPException("RightDaoImpl error");
		}
			
		return role;
	}
	
	public static ResultSet getallRoles() {
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
			String sql="select name from t_role";
			System.out.println(sql);
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet getallRolesSet() {
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
			String sql = "select * from t_role";
			System.out.println(sql);
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getFuncNamebyFuncNumString(String numString) {
		String returnString = "";
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		 String[] funcNumArray = numString.split(",");
		 for (int i = 0; i < funcNumArray.length; i++) {
			 System.out.println(funcNumArray[i]); 
			 try {
					st = con.createStatement();
					String sql = "select name from t_function where num = "+funcNumArray[i];
					System.out.println(sql);
					ResultSet rs = null;
					rs = st.executeQuery(sql);
					rs.next();
					returnString = returnString + rs.getString(1) + ",";
					if (i%10==0) {
						returnString += "\n";
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		      
		 return returnString;
	}
	
	public static boolean addaRole(Role newRole) {
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
			String sql = "insert into t_role (name,description,function_ids,del) values ('"+newRole.getName()+"','"+newRole.getDescription()+"','"+newRole.getFunction_id()+"',"+newRole.getDel()+")";
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
	
	public static boolean editaRole(Role upRole) {
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
			String sql = "update t_role set name = '"+upRole.getName()+"', description = '"+upRole.getDescription()+
					"', function_ids = '"+upRole.getFunction_id() + "' where id="+ upRole.getId();
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
	
	public static int getidbyName(String rname) {
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
			String sql = "select id from t_role where name = '"+rname+"'";
			System.out.println(sql);
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			rs.next();
			return Integer.parseInt(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
