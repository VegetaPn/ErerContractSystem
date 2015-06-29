package service;

import java.sql.ResultSet;

import dao.CustomerDao;
import model.Customer;

public class CustomerService {
	
	public Customer getCustomerbyUserID(String uid) {
		return CustomerDao.getCustomerbyUserID(uid);
	}
	
	public Customer[] getallCustomers() {
		return CustomerDao.getallCustomers();
	}
	
	public boolean editaCustomer(String uname, String cname, String cadr, String ctel, String cfax, String ccode, String cbank, String cact) {
		Customer upCustomer = new Customer();
		
		upCustomer.setName(cname);
		upCustomer.setAdress(cadr);
		upCustomer.setTel(ctel);
		upCustomer.setFax(cfax);
		upCustomer.setCode(ccode);
		upCustomer.setBank(cbank);
		upCustomer.setAccount(cact);
		
		return CustomerDao.editaCustomer(uname, upCustomer);
	}
}
