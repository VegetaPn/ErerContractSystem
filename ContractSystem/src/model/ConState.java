package model;

import java.sql.Timestamp;
import java.util.Date;

public class ConState {
private int id;
private int con_id;
private int type;
private Timestamp time;
private int del;
public ConState()
{
	this.id=0;
	this.con_id=0;
	this.type=0;
	this.del=0;
	this.time=new Timestamp(new Date().getDate());
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCon_id() {
	return con_id;
}
public void setCon_id(int con_id) {
	this.con_id = con_id;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public Timestamp getTime() {
	return time;
}
public void setTime(Timestamp time) {
	this.time = time;
}
public int getDel() {
	return del;
}
public void setDel(int del) {
	this.del = del;
}
}

