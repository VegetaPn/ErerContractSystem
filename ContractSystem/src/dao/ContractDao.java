package dao;
import java.io.*;
import java.sql.*;
import java.util.*;

import utils.*;
import model.*;
public class ContractDao {
	public static int getStateByID(int con_id) throws SQLException{
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
		String sql="select type from t_contract_state where con_id="+con_id;
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.next();
		int state=rs.getInt("type");
		return state;
		
	}
	
	public static ArrayList<String> getQdUser(int conid) throws SQLException{//获取合同的会签人
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
		
		String sql="select t_user.name from t_contract_process,t_user where t_user.id=t_contract_process.user_id and type=3 and con_id="+conid;
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		while(rs.next()){
			list.add(rs.getString(1));
		}
		return list;
	}
	public static ArrayList<String> getSpUser(int conid) throws SQLException{//获取合同的会签人
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
		
		String sql="select t_user.name from t_contract_process,t_user where t_user.id=t_contract_process.user_id and type=2 and con_id="+conid;
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		while(rs.next()){
			list.add(rs.getString(1));
		}
		return list;
	}
	public static ArrayList<String> getHqUser(int conid) throws SQLException{//获取合同的会签人
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
		
		String sql="select t_user.name from t_contract_process,t_user where t_user.id=t_contract_process.user_id and type=1 and con_id="+conid;
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		while(rs.next()){
			list.add(rs.getString(1));
		}
		return list;
	}
	
	public static int getQdNum(int userid) throws SQLException{//得到需要签订的合同数
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
		String sql="select count(*) from t_contract_process,t_contract_state where t_contract_process.con_id=t_contract_state.con_id and t_contract_state.type=5 and "
				    + " t_contract_process.state=1 and t_contract_process.type=3 and user_id="+userid;
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			rs.next();
		
		int num=rs.getInt(1);
		return num;
		
	}
	public static int getSpNum(int userid) throws SQLException{//得到需要审批的人数
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
		String sql="select count(*) from t_contract_process,t_contract_state where t_contract_process.con_id=t_contract_state.con_id and t_contract_state.type=4 and "
				    + " t_contract_process.state=1 and t_contract_process.type=2 and user_id="+userid;
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			rs.next();
		
		int num=rs.getInt(1);
		return num;
		
	} 
	public static int getDgNum(int userid) throws SQLException{
		int num=0;
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
       String sql="select con_id from t_contract_state where type=3  ";
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			Contract con1=new Contract();
			con1.setId(rs.getInt("con_id"));
			String sql1="select * from t_contract where id="+con1.getId();
			ResultSet rs1=null;
			rs1 = st.executeQuery(sql1);
			rs1.next();
			con1.setUseId(rs1.getInt("user_id"));
			if(con1.getUseId()==userid){
			num++;
			}
	    }
		return num;
		
	}
	public static int getHqNum(int userid) throws SQLException{
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
		String sql="select count(*) from t_contract_process,t_contract_state where t_contract_process.con_id=t_contract_state.con_id and t_contract_state.type=2 and "
				    + " t_contract_process.state=1 and t_contract_process.type=1 and user_id="+userid;
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			rs.next();
		
		int num=rs.getInt(1);
		return num;
		
	}
	
	public static ArrayList<Contract> getAllContracts() throws SQLException{
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
		
		String sql="select * from t_contract ";
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			Contract con1=new Contract();
			con1.setId(rs.getInt("id"));
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
	
	public static ArrayList<Contract> getAllContracts(int use_id) throws SQLException{
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
		
		String sql="select * from t_contract ";
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			Contract con1=new Contract();
			con1.setId(rs.getInt("id"));
			con1.setUseId(rs.getInt("user_id"));
			con1.setCustomer(rs.getString("customer"));
			con1.setName(rs.getString("name"));
			con1.setContent(rs.getString("content"));
			con1.setBeignTime(rs.getString("beginTime"));
			con1.setEndTime(rs.getString("endTime"));
			if(con1.getUseId()==use_id){
			list.add(con1);
			}
		}
		return list;
		
	}

	public static boolean deleteaContract(int con_id) {
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
			String presql = "delete from t_contract_process where con_id = " + con_id;
			String sql = "delete from t_contract_state where con_id = " + con_id;
			String fsql = "delete from t_contract where id = " + con_id;
			System.out.println(sql);
			ResultSet prers = st.executeQuery(presql);
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			ResultSet frs = st.executeQuery(fsql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
