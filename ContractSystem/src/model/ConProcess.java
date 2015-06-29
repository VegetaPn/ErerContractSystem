package model;
import java.sql.Timestamp;
import java.util.Date;

public class ConProcess {
private int id;

private int del;
private int con_id;
private int user_id;
private int type;
private int state;
private String content;
private Timestamp time;

public ConProcess()
{
	this.con_id=0;
	
	this.id=0;
	this.del=0;
	this.user_id=0;
	this.time=setTime();
	this.type=0;
	this.state=0;
	this.content="";
	
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
public int getCon_id() {
	return con_id;
}
public void setCon_id(int con_id) {
	this.con_id = con_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Timestamp getTime() {
	return time;
}
public Timestamp setTime() {
	
	return time;
	
}


}

