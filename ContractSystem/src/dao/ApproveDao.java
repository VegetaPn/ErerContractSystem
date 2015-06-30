package dao;
import java.io.*;
import java.sql.*;
import java.util.*;

import utils.*;
import model.*;
public class ApproveDao {
	public static  ArrayList<Contract> sped(int use_id) throws SQLException{//返回已经会签的列表
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
		String sql="select t_contract_process.con_id,t_contract.user_id,t_contract.customer,t_contract.name,t_contract.content,t_contract.beginTime,t_contract.endTime from t_contract_process,t_contract where "
				+ "t_contract_process.con_id=t_contract.id and t_contract_process.state!=1 and t_contract_process.type=2 and t_contract_process.user_id="+use_id;
		
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
	public static void sp(String judge,int use_id,int con_id,String content) throws SQLException{
		
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
		String sql="select del from t_contract_state where  con_id="+con_id+"and type=4";
		
		ResultSet rs=null;
		rs = st.executeQuery(sql);
		rs.next();
		int spnum=rs.getInt("del");//有几个审核人
		spnum=spnum-1;//减一个
		String sql1="update t_contract_process set content='"+content+"' where state=1 and type=2 and user_id="+use_id+"and con_id="+con_id;//更新会签内容
		//System.out.println(sql1);
		st.execute(sql1);
		if(judge.equals("agree")){
		String sql2="update t_contract_process set state=2  where state=1 and type=2 and user_id="+use_id+"and con_id="+con_id;//设置为审批完成
		st.execute(sql2);//审批操作
		
		
		if(spnum==0){//所有审批人已经审批完毕
		String sql3="update t_contract_state set type=5  where con_id="+con_id;//进入签订阶段
		st.execute(sql3);
		String sql4="select del from t_contract_process where  con_id="+con_id+"and type=3";//将签订的人数输入del
		rs=st.executeQuery(sql4);
		rs.next();
		int qdnum=rs.getInt("del");//读取签订的人数
		String sql5="update t_contract_state set del="+qdnum+"where con_id="+con_id;
		st.execute(sql5);
		}else{//还有其他会签人
			String sql6="update t_contract_state set del="+spnum+"where con_id="+con_id+"and type=4";
			st.execute(sql6);
		}
		}else{//合同被拒绝
			String sql7="update t_contract_process set state=3  where state=1 and type=2 and user_id="+use_id+"and con_id="+con_id;//设置为审批拒绝
			st.execute(sql7);//拒绝操作
			String sql8="update t_contract_state set type=-1  where con_id="+con_id;//设置成被决绝
			st.execute(sql8);
		}
		
	}
	public static  ArrayList<Contract> spContract(int use_id) throws SQLException{//返回需要审批的
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
		
		
		
		String sql="select t_contract_process.con_id,t_contract.user_id,t_contract.customer,t_contract.name,t_contract.content,t_contract.beginTime,t_contract.endTime from t_contract_process,t_contract,t_contract_state where "
				+ "t_contract_process.con_id=t_contract.id and t_contract_process.con_id=t_contract_state.con_id and t_contract_state.type=4 and t_contract_process.state=1 and t_contract_process.type=2 and t_contract_process.user_id="+use_id;
		
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
	public static boolean approveRight(int id){//判断有没有审核权限
		
		Role nrole = null;
		try {
			 nrole = RoleDao.getById(id);
		} catch (APPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//002代表会签权限
        String countersign="004";
        if(nrole.getFunction_id().indexOf(countersign)!=-1){//代表存在有会签权限
        	
        	return true;
        }else{
        	return false;
        }
		
	}
	public static ArrayList<User> userList() throws APPException{//返回有会签权限的用户
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
              Role nrole=RoleDao.getById(e.getId());//004代表审核权限
              String sign="004";
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
