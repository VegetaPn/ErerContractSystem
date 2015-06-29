package model;

import java.sql.Timestamp;
import java.util.Date;

public class ConAttach {
private int id;
private int del;
private int con_id;
private String filename;
private String path;
private String type;
private Timestamp uploadtime;
public ConAttach ()
{
	this.con_id=0;
	this.id=0;
	this.filename="";
	this.del=0;
	this.path="";
	this.type="";
	this.uploadtime=new Timestamp(new Date().getTime());
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
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Timestamp getUploadtime() {
	return uploadtime;
}
public void setUploadtime(Timestamp uploadtime) {
	this.uploadtime = uploadtime;
}

}

