package lanqiao.service;

import java.util.LinkedList;

import lanqiao.dao.*;
import lanqiao.entity.*;;
public class StudentService {

	//添加学生信息
	public static boolean add(Student stu){
		if(StudentControl.selectForId(stu.getStuId())!=null){
			boolean flg= StudentControl.insert(stu);
			return flg;
		}else{
			return false;
		}
		
	}
	//修改学生信息
	public static boolean update(int id,String newName,String newMajor){
		boolean flg=StudentControl.updateForId(id,newName, newMajor);
		return flg;
		
	}
	
	//查看所有学生信息
	public static LinkedList<Student> findAll(){
		LinkedList<Student> list=new LinkedList<Student>();
		list=StudentControl.selectAll();
		return list;
		
	}
	//根据学号查看学生信息
	public static Student findone(int stuId){
		Student student=new Student(); 
		student=StudentControl.selectForId(stuId);
		return student;
	}
	//根据学生姓名查看学生信息
	
	public static LinkedList<Student> findoneByName(String stuName){
		LinkedList<Student> list=new LinkedList<Student>();
		list=StudentControl.selectForName(stuName);
		return list;
	}
	
	//根据学号删除学生信息
	public static boolean delete(int stuid){
		boolean flg= StudentControl.deleteForId(stuid);
		return flg;
	}
	//根据姓名删除学生信息
	public static int deleteByName(String stuName){
		int a=StudentControl.deleteForName(stuName);
		return a;
	}
	
	
	//分页查看学生信息
	public static LinkedList<Student> findByPage(int currentPage,int pageSize){
		LinkedList<Student> list=new LinkedList<Student>();
		list=StudentControl.selectByPage(currentPage, pageSize);
		return list;
		
	}
	
	//获取记录总数
	public static int findCount(){
		int count;
		count=StudentControl.getCount();
		return count;
	}
	
	
}
