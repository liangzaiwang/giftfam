package lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lanqiao.entity.Student;

public class DBUtile {

	private static Connection conn=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static Context ctx=null;
	private static DataSource ds=null;
	
	
	public static DataSource getDataSource(){
		try {
			ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/student");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	
	public static List<Student> getBeanListHandler(){
		QueryRunner queryRunner=new QueryRunner(C3p0Demo.getDataSource());
		String sql="select * from student";
		List<Student> list=null;
		try {
			 list =queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static Student getBeanHandler(){
		QueryRunner queryRunner=new QueryRunner(C3p0Demo.getDataSource());
		String sql="selcet * from Student where stuid=1001";
		Student stu=null;
		try {
			stu=queryRunner.query(sql, new BeanHandler<Student>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	
	}
	
	public static void main(String[] args) {
//		List<Student> list=DBUtile.getBeanListHandler();
//		
//		for (Student student : list) {
//		
//			System.out.println(student);
//		}
		
		Student stu=new Student();
		stu=getBeanHandler();
		System.out.println(stu);
	}
	

	
	
}
