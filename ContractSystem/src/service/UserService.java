package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.RoleDao;
import dao.UserDao;
import dao.RightDao;
import model.Role;
import model.User;
import utils.APPException;
public class UserService {
	
	public static boolean register(User new_user, String userfax) throws SQLException
	{
		
		if(!UserDao.isExist(new_user.getName()))
		{
			
			UserDao.add(new_user, userfax);
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int login(String name, String password)
	{
		int id=-1;
		try {
			id = UserDao.login(name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public  Role getUserRole(int userid)throws APPException
	{
	  
		RoleDao rd=new RoleDao();
	    Role role;
	   role=rd.getById(userid);
	
	   return role;
	}
	public ResultSet getids() {
		return UserDao.getallids();
	}
	public String getName(String id) {
		return UserDao.getNamebyID(id);
	}
	public boolean updatePermission(String id, String upRight) {
		return RightDao.updateRight(id, upRight);
	}
	public boolean updateUserName(String id, String upName) {
		return UserDao.updateName(id, upName);
	}
	public boolean deleteUser(int id) {
		return UserDao.deleteUser(id);
	}
	public String[] getallUserNames() {
		return UserDao.getallUserNames();
	}
}
