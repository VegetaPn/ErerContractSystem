package dao;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import utils.*;
import model.*;

public class AssignDao{
    static ResultSet rs1=null;
	static ResultSet rs2=null;
	
	public static List<User> userList(){
		 List<User> userlist=new ArrayList<User>();
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
			String sql="select ID,name from t_role where description='Operator'";
			
			ResultSet rs=null;
			
			try {
				rs = st.executeQuery(sql);
				
			while(rs.next())
			{
				User e=new User();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				userlist.add(e);
		
			}
		} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userlist;
	 }
	
	
	
 //查询合同是否被分配，返回合同集
 public static ArrayList<Contract> assignList(){
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
		String sql="select t_contract.id,t_contract.user_id,customer,t_contract.name,t_contract.content,t_contract_state.type,beginTime,endTime from t_contract ,t_contract_state where t_contract.id=t_contract_state.con_id and t_contract_state.del=0";
		System.out.println(sql);
		ResultSet rs=null;
		
		try {
			rs = st.executeQuery(sql);
			String temp="";
			
		while(rs.next())
		{
			
			
			if(rs.getInt("type")==1){//1代表需要分配的合同
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
		}
	} 
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
 }
 

 //进行分配
 public static void assignhq(int con_id,int userid,int hqnum){
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
		
		ConProcess con_process= new ConProcess();
		ConState con_state=new ConState();
		ResultSet rs=null;
		con_process.setCon_id(con_id);
		con_process.setUser_id(userid);
		con_process.setType(1);//1代表会签
		con_process.setState(1);
		
		int current_type = 1;
		String sql_insert="insert into t_contract_process values("+con_process.getId()+","+con_process.getCon_id()+","+con_process.getUser_id()+","+con_process.getType()+","+con_process.getState()+",'"+con_process.getContent()+"'"+",default,"+hqnum+")";
		 System.out.println(sql_insert);
		try {
			 st.execute(sql_insert);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 String update_state="update t_contract_state set type=2 where con_id="+con_id;//2代表已经分配但是还没有会签
		 String update2="update t_contract_state set del="+hqnum+" where con_id="+con_id;
		 try {
			 st.execute(update_state);
			 st.execute(update2);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
 	
}
 
 public static void assignsp(int con_id,int userid,int spnum){
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
		
		ConProcess con_process= new ConProcess();
		ConState con_state=new ConState();
		ResultSet rs=null;
		con_process.setCon_id(con_id);
		con_process.setUser_id(userid);
		con_process.setType(2);//3代表sign
		con_process.setState(1);
		
		int current_type = 1;
		String sql_insert="insert into t_contract_process values("+con_process.getId()+","+con_process.getCon_id()+","+con_process.getUser_id()+","+con_process.getType()+","+con_process.getState()+",'"+con_process.getContent()+"'"+",default,"+spnum+")";
		 try {
			 st.execute(sql_insert);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 String update_state="update t_contract_state set type=2 where con_id="+con_id;//2代表已经分配但是还没有会签
		// String update2="update t_contract_process set del="+spnum+" where con_id="+con_id;
		 try {
			 st.execute(update_state);
			// st.execute(update2);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
 	
}
 public static void assignqd(int con_id,int userid,int qdnum){
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
		
		ConProcess con_process= new ConProcess();
		//ConState con_state=new ConState();
		//ResultSet rs=null;
		con_process.setCon_id(con_id);
		con_process.setUser_id(userid);
		con_process.setType(3);//3代表sign
		con_process.setState(1);
		
		
		String sql_insert="insert into t_contract_process values("+con_process.getId()+","+con_process.getCon_id()+","+con_process.getUser_id()+","+con_process.getType()+","+con_process.getState()+",'"+con_process.getContent()+"'"+",default,"+qdnum+")";
		 try {
			 st.execute(sql_insert);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 String update_state="update t_contract_state set type=2 where con_id="+con_id;//2代表已经分配但是还没有会签
		 //String update2="update t_contract_process set del="+qdnum+" where con_id="+con_id;
		 try {
			 st.execute(update_state);
			 //st.execute(update2);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
 	
}
}
