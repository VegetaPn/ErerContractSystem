package model;
import java.sql.Timestamp;
import java.util.Date;


public class Log {
private int id;
private int del;
private int ueser_id;
private Timestamp time;
private String content;
public Log()
{
	this.del=0;
	this.content="";
	this.id=0;
	this.time=new Timestamp(new Date().getTime());
	this.ueser_id=0;
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
public int getUeser_id() {
	return ueser_id;
}
public void setUeser_id(int ueser_id) {
	this.ueser_id = ueser_id;
}
public Date getTimestamp() {
	return time;
}
public void setTimestamp(Timestamp time) {
	this.time = time;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
}
