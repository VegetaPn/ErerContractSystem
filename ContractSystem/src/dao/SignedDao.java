package dao;
import java.io.*;
import java.sql.*;
import java.util.*;

import utils.*;
import model.*;
public class SignedDao {
public static boolean signRight(int id){//�ж���û�����Ȩ��
		
		Role nrole = null;
		try {
			 nrole = RoleDao.getById(id);
		} catch (APPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//005����ǩ��Ȩ��
        String countersign="005";
        if(nrole.getFunction_id().indexOf(countersign)!=-1){//���������ǩ��Ȩ��
        	
        	return true;
        }else{
        	return false;
        }
		
	}
	public static  ArrayList<Contract> qded(int use_id) throws SQLException{//�����Ѿ�ǩ�����б�
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
				+ "t_contract_process.con_id=t_contract.id and t_contract_process.state=2 and t_contract_process.type=3 and t_contract_process.user_id="+use_id;
		
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
		int spnum=rs.getInt("del");//�м��������
		spnum=spnum-1;//��һ��
		String sql1="update t_contract_process set content='"+content+"' where state=1 and type=3 and user_id="+use_id+"and con_id="+con_id;//���»�ǩ����
		//System.out.println(sql1);
		st.execute(sql1);
		
		String sql2="update t_contract_process set state=2  where state=1 and type=3 and user_id="+use_id+"and con_id="+con_id;//����Ϊ�������
		st.execute(sql2);//��������
		
		
		if(spnum==0){//�����������Ѿ��������
		String sql3="update t_contract_state set type=6  where con_id="+con_id;//��ͬ���
		st.execute(sql3);
		
		}else{//����������ǩ��
			String sql6="update t_contract_state set del="+spnum+"where con_id="+con_id+"and type=5";
			st.execute(sql6);
		}
		
		}
		
	
	public static  ArrayList<Contract> qdContract(int use_id) throws SQLException{//������Ҫǩ����
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
				+ "t_contract_process.con_id=t_contract.id and t_contract_process.con_id=t_contract_state.con_id and t_contract_state.type=5 and t_contract_process.state=1 and t_contract_process.type=3 and user_id="+use_id;
		
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
	public static ArrayList<User> userList() throws APPException{//������ǩ��Ȩ�޵��û�
		
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
               Role nrole=RoleDao.getById(e.getId());//005����ǩ��Ȩ��
               String sign="005";
               if(nrole.getFunction_id().indexOf(sign)!=-1){//��������л�ǩȨ��
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
