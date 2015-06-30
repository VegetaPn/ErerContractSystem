package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.APPException;
import utils.DBUtil;

public class AttachDao {
	public static boolean isAttach(String name){//判断是否有附件
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
		String sql="select * from t_contract_attachment where fileName='"+name+"'";
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
	public static String getPathByName(String name) throws SQLException{
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
			String sql="select path from t_contract_attachment where fileName='"+name+"'";
			ResultSet rs=null;
			
			try {
				rs = st.executeQuery(sql);
				
			} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			rs.next();
			return rs.getString(1);
				
		
	}
	public static void attach(String name,String path){//添加入附件表中
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
			String sql="insert into t_contract_attachment values (1,1,'"+name+"','"+path+"',"+"'-',"+"default,0)";
			System.out.println(sql);
			try {
				 st.execute(sql);
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				System.out.println("DRAFT WRONG");
			}
}
}
