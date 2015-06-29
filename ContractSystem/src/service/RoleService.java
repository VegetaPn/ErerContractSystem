package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.RoleDao;
import dao.UserDao;
import dao.RightDao;
import model.Role;
import model.User;
import utils.APPException;
public class RoleService {
	public  Role getUserRole(int userid)throws APPException
	{
		RoleDao rd=new RoleDao();
	    Role role;
	   role=rd.getById(userid);
	
	   return role;
	}
	
	public ResultSet getallRoleNames() {
		return RoleDao.getallRoles();
	}
	
	public ResultSet getallRoleSet() {
		return RoleDao.getallRolesSet();
	}
	
	public String getFuncNamebyFuncNumString(String nString) {
		return RoleDao.getFuncNamebyFuncNumString(nString);
	}
	
	public boolean addaRole(Role newRole) {
		return RoleDao.addaRole(newRole);
	}
	
	public boolean editaRole(Role upRole) {
		return RoleDao.editaRole(upRole);
	}
}
