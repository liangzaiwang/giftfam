package org.lanqiao.service;

import java.util.List;

import org.lanqiao.dao.StudentDao;
import org.lanqiao.entity.Student;

//业务逻辑层
public class StudentService {
	//增加
	public boolean addStudent(Student stu) {
		StudentDao dao = new StudentDao();
		//先判断是否存在
		int stuNo = stu.getStuNo();
		if(dao.isExistByNo(stuNo)) {
			System.out.println("学生信息已经存在，插入无效");
			return false;
		}else {
			return dao.addStudent(stu);
		
		}
	}
	//查询全部学生信息
	public List<Student> queryAllStudents(){
		StudentDao dao = new StudentDao();
		return dao.findAllStudents();
	}
}
