package dao;
import java.io.*;
import java.sql.*;
import java.util.*;

import utils.*;
import model.*;
public class ContractDao {
	public static int getuseIdByconid(int con_id)throws SQLException{
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
		String sql="select user_id from t_contract where id="+con_id;
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.next();
		return rs.getInt(1);
		
		
	}
	public static String getMailByName(String name)throws SQLException{
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
		String sql="select t_customer.fax from t_customer,t_user where t_customer.num=t_user.id and t_user.name='"+name+"'";
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs.next();
		return rs.getString(1);
		
	}
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
		int state=0;
		while(rs.next()){
			state=rs.getInt("type");
		}
		return state;
		
	}
	
	public static ArrayList<String> getQdUser(int conid) throws SQLException{//鑾峰彇鍚堝悓鐨勪細绛句汉
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
	public static ArrayList<String> getSpUser(int conid) throws SQLException{//鑾峰彇鍚堝悓鐨勪細绛句汉
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
	public static ArrayList<String> getHqUser(int conid) throws SQLException{//鑾峰彇鍚堝悓鐨勪細绛句汉
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
	
	public static int getQdNum(int userid) throws SQLException{//寰楀埌闇�瑕佺璁㈢殑鍚堝悓鏁�
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
	public static int getSpNum(int userid) throws SQLException{//寰楀埌闇�瑕佸鎵圭殑浜烘暟
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
       String sql="select count(*) from t_contract_state,t_contract where t_contract_state.con_id="
       		+ "t_contract.id and t_contract_state.type=3 and t_contract.user_id= "+userid;
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		
          rs.next();
		
		 num=rs.getInt(1);
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
