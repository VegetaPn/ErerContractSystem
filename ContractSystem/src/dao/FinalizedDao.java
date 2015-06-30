package dao;
import java.io.*;
import java.sql.*;
import java.util.*;

import utils.*;
import model.*;
public class FinalizedDao {
	public static ArrayList<Contract> afterFinalized(int use_id) throws SQLException{//返回已经定稿的
		ArrayList<Contract> list=new ArrayList<Contract>();
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
		//String sql="select con_id from t_contract_state where type>3  ";
		String sql="select t_contract_state.con_id,t_contract.user_id,t_contract.customer,t_contract.name,t_contract.content,t_contract.beginTime,t_contract.endTime from t_contract_state,t_contract where "
				+ "t_contract_state.con_id=t_contract.id and t_contract_state.type>3 and t_contract.user_id="+use_id;
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		
		
		
		while(rs.next())
		{
			
			
			Contract con1=new Contract();
			con1.setId(rs.getInt("con_id"));
			con1.setUseId(rs.getInt("user_id"));
			con1.setCustomer(rs.getString("customer"));
			con1.setName(rs.getString("name"));
			con1.setContent(rs.getString("content"));
			con1.setBeignTime(rs.getString("beginTime"));
			con1.setEndTime(rs.getString("endTime"));
			list.add(con1);
			
		}
		
		return list;
}
	public static void updateContent(int con_id,String content) throws SQLException{
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
		String sql="update t_contract set content='"+ content+"'where id="+con_id;
		st.execute(sql);
		//之后更新合同状态
		String sql1="update t_contract_state set type=4 where con_id="+con_id;
		st.execute(sql1);
	}
	public static ArrayList<String> seehqContent(int con_id) throws SQLException{//查看会签内容
		ArrayList<String> list=new ArrayList<String>();
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
		String sql="select user_id,content from t_contract_process where type=1 and state=2 and con_id=  "+con_id;
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		while(rs.next())
		{
			int useid=rs.getInt("user_id");
			String name=UserDao.getNameByID(useid);
			String hq=name+" 的意见: "+rs.getString("content");
			list.add(hq);
		}
		return list;
	}
	public static ArrayList<Contract> toBeFinalized(int use_id) throws SQLException{
		ArrayList<Contract> list=new ArrayList<Contract>();
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
		String sql="select t_contract_state.con_id,t_contract.user_id,t_contract.customer,t_contract.name,t_contract.content,t_contract.beginTime,t_contract.endTime from t_contract_state,t_contract where "
				+ "t_contract_state.con_id=t_contract.id and t_contract_state.type=3 and t_contract.user_id="+use_id;
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		
		
		
		while(rs.next())
		{
			
			
			Contract con1=new Contract();
			con1.setId(rs.getInt("con_id"));
			con1.setUseId(rs.getInt("user_id"));
			con1.setCustomer(rs.getString("customer"));
			con1.setName(rs.getString("name"));
			con1.setContent(rs.getString("content"));
			con1.setBeignTime(rs.getString("beginTime"));
			con1.setEndTime(rs.getString("endTime"));
			list.add(con1);
			
		}
		
		return list;
}
}
