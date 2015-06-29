package model;

import java.util.Date;



public class Contract {
	private int id;
	private int useId;
	private String  customer;
	private String num;
	private String name;	
	private String beignTime;
	private String endTime;
	private String content;
	private int del;
	public Contract(){
		this.id=0;
		this.useId=0;
		this.customer=null;
		this.num=null;
		this.name=null;
		this.beignTime=null;
		this.endTime=null;
		this.content=null;
		this.del=0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUseId() {
		return useId;
	}
	public void setUseId(int useId) {
		this.useId = useId;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
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
	public String getBeignTime() {
		return beignTime;
	}
	public void setBeignTime(String beignTime) {
		this.beignTime = beignTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	
}
