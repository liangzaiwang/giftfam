package org.lanqiao.entity;

public class Student {
private int stuNo;
private String stuName;
private int stuAge;
private String gName;

public Student() {
	
}

public Student(int stuNo, String stuName, int stuAge, String gName) {
	super();
	this.stuNo = stuNo;
	this.stuName = stuName;
	this.stuAge = stuAge;
	this.gName = gName;
}

public int getStuNo() {
	return stuNo;
}
public void setStuNo(int stuNo) {
	this.stuNo = stuNo;
}
public String getStuName() {
	return stuName;
}
public void setStuName(String stuName) {
	this.stuName = stuName;
}
public int getStuAge() {
	return stuAge;
}
public void setStuAge(int stuAge) {
	this.stuAge = stuAge;
}
public String getgName() {
	return gName;
}
public void setgName(String gName) {
	this.gName = gName;
}

}
