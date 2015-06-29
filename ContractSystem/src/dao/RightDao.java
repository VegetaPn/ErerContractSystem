package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.*;
import utils.APPException;
import utils.DBUtil;

public class RightDao {
	public static boolean updateRight(String id, String upRight) {
		Connection con = null;
		int right = -1;
		if(upRight.equals("admin")) { 
			right = 1;
		} else {
			right = 2;
		}
		try {
			con = DBUtil.getConnection();
		} catch (APPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "update t_right set role_id = "+right+" where user_id='"+ id +"' ";
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
		
