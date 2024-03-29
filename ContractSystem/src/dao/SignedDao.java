package dao;
import java.io.*;
import java.sql.*;
import java.util.*;

import utils.*;
import model.*;
public class SignedDao {
public static boolean signRight(int id){//判断有没有审核权限
		
		Role nrole = null;
		try {
			 nrole = RoleDao.getById(id);
		} catch (APPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//005代表签订权限
        String countersign="005";
        if(nrole.getFunction_id().indexOf(countersign)!=-1){//代表存在有签订权限
        	
        	return true;
        }else{
        	return false;
        }
		
	}
	public static  ArrayList<Contract> qded(int use_id) throws SQLException{//返回已经签订的列表
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
		String sql="select con_id from t_contract_process where state=2 and type=3 and user_id="+use_id;
		
		
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
			con1.setCustomer(rs1.getString("customer"));
			con1.setName(rs1.getString("name"));
			con1.setContent(rs1.getString("content"));
			con1.setBeignTime(rs1.getString("beginTime"));
			con1.setEndTime(rs1.getString("endTime"));
			list.add(con1);
		}
		return list;
	}
public static void qd(int use_id,int con_id,String content) throws SQLException{
		
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
		String sql="select del from t_contract_state where  con_id="+con_id+"and type=5";
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		rs.next();
		int spnum=rs.getInt("del");//有几个审核人
		spnum=spnum-1;//减一个
		String sql1="update t_contract_process set content='"+content+"' where state=1 and type=3 and user_id="+use_id+"and con_id="+con_id;//更新会签内容
		//System.out.println(sql1);
		st.execute(sql1);
		
		String sql2="update t_contract_process set state=2  where state=1 and type=3 and user_id="+use_id+"and con_id="+con_id;//设置为审批完成
		st.execute(sql2);//审批操作
		
		
		if(spnum==0){//所有审批人已经审批完毕
		String sql3="update t_contract_state set type=6  where con_id="+con_id;//合同完成
		st.execute(sql3);
		
		}else{//还有其他会签人
			String sql6="update t_contract_state set del="+spnum+"where con_id="+con_id+"and type=5";
			st.execute(sql6);
		}
		
		}
		
	
	public static  ArrayList<Contract> qdContract(int use_id) throws SQLException{//返回需要签订的
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
		
		String sql="select t_contract_process.con_id from t_contract_process,t_contract_state where t_contract_process.con_id=t_contract_state.con_id and t_contract_state.type=5 and t_contract_process.state=1 and t_contract_process.type=3 and user_id="+use_id;
		
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
			con1.setCustomer(rs1.getString("customer"));
			con1.setName(rs1.getString("name"));
			con1.setContent(rs1.getString("content"));
			con1.setBeignTime(rs1.getString("beginTime"));
			con1.setEndTime(rs1.getString("endTime"));
			list.add(con1);
		}
		return list;
		
		}
	public static ArrayList<User> userList() throws APPException{//返回有签订权限的用户
		
		ArrayList<User> userlist=new ArrayList<User>();
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
			String sql="select ID,name from t_user ";
			
			ResultSet rs=null;
			
			try {
				rs = st.executeQuery(sql);
				
			while(rs.next())
			{
				User e=new User();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
               Role nrole=RoleDao.getById(e.getId());//005代表签订权限
               String sign="005";
               if(nrole.getFunction_id().indexOf(sign)!=-1){//代表存在有会签权限
               	userlist.add(e);
               }
			}
		} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return userlist;
	 }
}
