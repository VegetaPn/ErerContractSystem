package model;
public class Customer {
private int id;
private String num;
private String name;
private String adress;
private String tel;
private String fax;
private String code;
private String bank;
private String account;
private int  del;
public Customer()
{
	this.id=0;
	this.num="";
	this.name="";
	this.adress="";
	this.tel="";
	this.fax="";
	this.code="";
	this.bank="";
	this.account="";
	this.del=0;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getFax() {
	return fax;
}
public void setFax(String fax) {
	this.fax = fax;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getBank() {
	return bank;
}
public void setBank(String bank) {
	this.bank = bank;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public int getDel() {
	return del;
}
public void setDel(int del) {
	this.del = del;
}
}

