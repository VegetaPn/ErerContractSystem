package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
//import java.sql.Date;
//import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.*;
import utils.APPException;
import utils.DBUtil;
public class DraftDao {
	public static boolean IsExist(String con_name) throws SQLException{
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
		String sql="select * from t_contract where name='"+con_name+"'";
		ResultSet rs=null;
		
		try {
			rs = st.executeQuery(sql);} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
		
			if(rs.next())//找到返回true
					return true;
			else return false;
			
	}
	
	
	public static void add(String path,String con_name,String btime,String etime,String content,String customer,int userid) throws ParseException{
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try{
			st = con.createStatement();
		
		Contract new_contract =new Contract();;
		ConProcess new_conprocess = new ConProcess();
		ConState new_constate = new ConState();
		User new_user=new User();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		//Date date1 = (Date) sdf.parse(btime);
		//Date date2 = (Date) sdf.parse(etime);
		int contract_id=0;
		ResultSet rs = null;
		//System.out.print(path);
		// java.text.DateFormat timestyle = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try{
			//if(path==null){//path为空,没有附件
		
				String sql_contract="insert into t_contract(id,num,name,user_id,customer,content,beginTime,endTime,del) values("+new_contract.getId()+",'"+new_contract.getNum()+"','"+con_name+"',"+userid+",'"+customer+"','"+content+"','"+btime+"','"+etime+"',"+new_contract.getDel()+")";
			System.out.println(sql_contract);
			st.execute(sql_contract);
			String sql_id="select id from t_contract where name='"+ con_name+"' ";
			rs = st.executeQuery(sql_id);
			rs.next();
			contract_id=rs.getInt("id");
			System.out.println(contract_id);
			//}else{//如果有附件的话要加文件的内容，加入到路径表中
			/*String sql_contract="insert into t_contract(id,num,name,user_id,customer,content,beginTime,endTime,del) values("+new_contract.getId()+",'"+new_contract.getNum()+"','"+con_name+"',"+userid+",'"+customer+"','"+path+"','"+btime+"','"+etime+"',"+new_contract.getDel()+")";
				st.execute(sql_contract);
				
			}*/
			//String sql_conProcess="insert into t_contract_process values("+new_conprocess.getId()+","+new_contract.getId()+","+new_user.getId()+","+1+","+1+",'"+new_conprocess.getContent()+"',now(),"+new_conprocess.getDel()+");";
			//st.execute(sql_conProcess);
			String sql_conState="insert into t_contract_state values("+new_contract.getId()+","+contract_id+","+1+",default,"+new_constate.getDel()+")";
			st.execute(sql_conState);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
		
		//add customer
public static void addcustomer(String name,String phone,String address,String fax,String mail,String bankname,String bankaccount){
			Connection con = null;
			try {
				con = DBUtil.getConnection();
			} catch (APPException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Statement st = null;
			try{
				st = con.createStatement();
			
			Customer new_cusomer=new Customer();
			
			try{
				String add_customer="insert into t_Customer values("+new_cusomer.getId()+",'"+new_cusomer.getNum()+"','"+name+"','"+address+"','"+phone+"','"+fax+"','"+mail+"','"+bankname+"','"+bankaccount+"',"+new_cusomer.getDel()+")";
				st.execute(add_customer);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
public static List<Customer> customerList(){
	 List<Customer> customerlist=new ArrayList<Customer>();
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
		String sql="select name from t_customer ";
		
		ResultSet rs=null;
		
		try {
			rs = st.executeQuery(sql);
			
		while(rs.next())
		{
			Customer e=new Customer();
			
			e.setName(rs.getString("name"));
			customerlist.add(e);
	
		}
	} 
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerlist;
}
}
