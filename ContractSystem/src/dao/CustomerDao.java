package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.APPException;
import utils.DBUtil;
import model.Customer;

public class CustomerDao {
	public static Customer getCustomerbyUserID(String uid) {
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
			String sql = "select * from t_customer where num = '"+ uid + "'";
			System.out.println(sql);
			ResultSet rs = null;
			rs = st.executeQuery(sql);
			rs.next();
			
			Customer reCustomer = new Customer();
			reCustomer.setId(rs.getInt(1));
			reCustomer.setNum(uid);
			reCustomer.setName(rs.getString(3));
			reCustomer.setAdress(rs.getString(4));
			reCustomer.setTel(rs.getString(5));
			reCustomer.setFax(rs.getString(6));
			reCustomer.setCode(rs.getString(7));
			reCustomer.setBank(rs.getString(8));
			reCustomer.setAccount(rs.getString(9));
			reCustomer.setDel(rs.getInt(10));
			
			return reCustomer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Customer[] getallCustomers() {
		int customernumber = 0, count = 0;
		Customer[] allCustomers = null;
		ResultSet allids = UserDao.getallids();
		
		try {
			allids.last();
			customernumber = allids.getRow();
			allids.beforeFirst();
			
			allCustomers = new Customer[customernumber];
			
			while (allids.next()) {
				allCustomers[count] = getCustomerbyUserID(allids.getString(1));
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allCustomers;
	}
	
	public static boolean editaCustomer(String uname, Customer upCustomer) {
		String cnum = UserDao.getUseridbyName(uname);
		
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
			String sql = "update t_customer set name = '"+upCustomer.getName()+"',"+" address = '"+upCustomer.getAdress()+"',"+
							" tel = '"+upCustomer.getTel()+"',"+" fax = '"+upCustomer.getFax()+"',"+
							" code = '"+upCustomer.getCode()+"',"+" bank = '"+upCustomer.getBank()+"',"+
							" account = '"+upCustomer.getAccount()+"' "+ "where num='"+ cnum +"' ";
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
}
