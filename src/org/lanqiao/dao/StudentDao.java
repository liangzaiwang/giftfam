package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Student;
//数据访问层
public class StudentDao {
	public static final String DRIVER="oracle.jdbc.OracleDriver";
	public static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USERNAME="scott";
	public static final String PASSWORD="tiger";
	//增加
	public  static boolean addStudent(Student stu) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String  sql = "insert into student(stuNo,stuName,stuAge,gName) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getStuNo());
			pstmt.setString(2, stu.getStuName());
			pstmt.setInt(3, stu.getStuAge());
			pstmt.setString(4, stu.getgName());
			
			int result = pstmt.executeUpdate();
			if(result >0) {
				System.out.println("插入成功");
				return true;
			}else {
				System.out.println("插入失败");
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
		
	}
	//判断学生是否存在
	public boolean isExistByNo(int stuNo) {
		//查询学生是否存在
		if(findStudentByStuNo(stuNo)== null) {
			System.out.println("学生不存在");
			return false;
		}else {
			System.out.println("学生已存在");
			return true;
		}
	}
	
	public Student findStudentByStuNo(int stuNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			String sql = "select * from student where stuNo= ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, stuNo);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int sNo = rs.getInt(1);
				String sName = rs.getString(2);
				int sAge = rs.getInt(3);
				String gName = rs.getString(4);
				
				Student  stu = new Student();
				stu.setgName(gName);
				stu.setStuAge(sAge);
				stu.setStuName(sName);
				stu.setStuNo(sNo);
				return stu;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return null;
	}
	
	//查询全部学生
	public List<Student> findAllStudents(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
			try {
				Class.forName(DRIVER);
				conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
				String sql = "select * from student";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int stuNo = rs.getInt(1);
					String stuName = rs.getString(2);
					int stuAge = rs.getInt(3);
					String gName = rs.getString(4);
					Student stu = new Student(stuNo,stuName,stuAge,gName);
					list.add(stu);
					
				}
				return list;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return null;
	}
	
//	public static void main(String[] args) {
//		Student stu = new Student();
//		stu.setStuName("aa");
//		stu.setStuAge(12);
//		stu.setStuNo(11);
//		stu.setgName("cc");
//		addStudent(stu);
//	}
}
