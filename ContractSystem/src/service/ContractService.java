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
			return "�ȴ�����";
		case 2:
			return "�ȴ���ǩ";
		case 3:
			return "�ȴ�����";
		case 4:
			return "�ȴ����";
		case 5:
			return "�ȴ�ǩ��";
		case 6:
			return "��ͬ�����";
		case -1:
			return "��ͬ��˾ܾ�";
		default:
			return "Error";
		}
	}
	
	public boolean deleteaContract(int con_id) {
		return ContractDao.deleteaContract(con_id);
	}
}
