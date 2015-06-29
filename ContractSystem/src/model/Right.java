package model;
public class Right {
private int id;
private int user_id;
private int role_id;
private String description;
private int del;
public Right()
{
	this.del=0;
	this.description="";
	this.id=0;
	this.user_id=0;
	this.role_id=0;}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getRole_id() {
	return role_id;
}
public void setRole_id(int role_id) {
	this.role_id = role_id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getDel() {
	return del;
}
public void setDel(int del) {
	this.del = del;
}
}

