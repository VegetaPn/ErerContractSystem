package model;

public class Role {
private int id;
private String name;
private String function_id;
private String description;
private int del;
public Role()
{
	this.del=0;
	this.id=0;
	this.description="";
	this.function_id="";
	this.name="";
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFunction_id() {
	return function_id;
}
public void setFunction_id(String function_id) {
	this.function_id = function_id;
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
