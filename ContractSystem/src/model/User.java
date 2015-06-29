package model;

public class User {
private int id;
static int num=13;
private int del;
private String password;
private String name;
public User()
{
	this.del=0;
	this.num++;
	this.id=this.num;
	
	this.name="";
	this.password="";
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getDel() {
	return del;
}
public void setDel(int del) {
	this.del = del;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}

