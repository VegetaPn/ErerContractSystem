package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ContractDao;
import model.Contract;

public class ContractService {
	public Contract[] getallContracts() {
		ArrayList<Contract> list = null;
		Contract[] allContracts = null;
		try {
			list = ContractDao.getAllContracts();
			allContracts = (Contract[]) list.toArray(new Contract[list.size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allContracts;
	}
	
	public String getContractStatebyConid(int con_id) {
		int stateID = 0;
		
		try {
			stateID = ContractDao.getStateByID(con_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch (stateID) {
		case 1:
			return "等待分配";
		case 2:
			return "等待会签";
		case 3:
			return "等待定稿";
		case 4:
			return "等待审核";
		case 5:
			return "等待签订";
		case 6:
			return "合同已完成";
		case -1:
			return "合同审核拒绝";
		default:
			return "Error";
		}
	}
	
	public boolean deleteaContract(int con_id) {
		return ContractDao.deleteaContract(con_id);
	}
}
