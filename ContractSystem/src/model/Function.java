package model;

public class Function {
private int id;
private int del;
private String num;
private String name;
private String URL;
private String description;
public Function()
{
	this.id=0;
	this.del=0;
	this.num="";
	this.name="";
	this.URL="";
	this.description="";
	
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
public String getURL() {
	return URL;
}
public void setURL(String uRL) {
	URL = uRL;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
}

