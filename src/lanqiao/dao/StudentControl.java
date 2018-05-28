package lanqiao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import lanqiao.entity.Student;

public class StudentControl {

	private static String Driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user = "scott";
	private static String password = "tiger";
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	// 连接数据库
	public static void ConnectDBMS() {
		try {
//			Class.forName(Driver);
//			conn = DriverManager.getConnection(url, user, password);
			//conn=DBUtile.getDataSource().getConnection();
			//conn=DBCPDemo.getDataSourceDBCP().getConnection();
			conn=C3p0Demo.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 断开数据库连接
	public static void CloseConnect() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 增加
	public static boolean insert(Student stu) {
		ConnectDBMS();
		int a = 0;// 判断是否添加成功
		String sql = "insert into student(stuid,stuname,major)values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stu.getStuId());
			ps.setString(2, stu.getStuName());
			ps.setString(3, stu.getMajor());
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnect();
		}
		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 根据学生姓名删除
	public static int deleteForName(String name) {
		ConnectDBMS();
		int a = 0;// 判断是否成功
		String sql = "delete from student where stuName=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnect();
		}
		if (a > 0) {
			return a;
		} else {
			return a;
		}
	}

	// 根据学生学号删除
	public static boolean deleteForId(int id) {
		ConnectDBMS();
		int a = 0;// 判断是否成功
		String sql = "delete from student where stuid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnect();
		}
		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 根据学生编号修改信息
	public static boolean updateForId(int id,String newName, String newMajor) {
		ConnectDBMS();
		int a = 0;// 判断是否修改成功
		String sql = "update student set stuname=?,major=? where stuid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, newMajor);
			ps.setInt(3, id);
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (a > 0) {
			return true;
		} else {
			return false;
		}

	}
	// 根据学生编号查看学生信息
	public static Student selectForId(int id) {
		ConnectDBMS();
		Student stu = new Student();
		String sql = "select stuid,stuname,major from student where stuid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				stu.setStuId(rs.getInt("stuid"));
				stu.setStuName(rs.getString("stuname"));
				stu.setMajor(rs.getString("major"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnect();
		}
		return stu;

	}

	// 根据学生姓名查看学生信息
	public static LinkedList<Student> selectForName(String name) {
		LinkedList<Student> list=new LinkedList<Student>();
		ConnectDBMS();
		String sql = "select stuid,stuname,major from student where stuname=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setStuId(rs.getInt("Stuid"));
				stu.setStuName(rs.getString("stuname"));
				stu.setMajor(rs.getString("major"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnect();
		}
		return list;
	}
	//查询所有学生信息
	public static LinkedList<Student> selectAll() {
		ConnectDBMS();
		LinkedList<Student> list=new LinkedList<Student>();
		String sql = "select stuid,stuname,major from student order by stuId asc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setStuId(rs.getInt("stuid"));
				stu.setStuName(rs.getString("stuname"));
				stu.setMajor(rs.getString("major"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnect();
		}
		return list;
	}

	
	//分页查询
	public static LinkedList<Student> selectByPage(int currentPage,int pageSize){
		LinkedList<Student> list=new LinkedList<Student>();
		String sql="select * from (select rownum r,t.* from (select s.* from student s order by stuid asc ) t where rownum<= ?*? )where r>=((?)*?+1)";
		ConnectDBMS();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,currentPage );
			ps.setInt(2, pageSize);
			ps.setInt(3, currentPage-1);
			ps.setInt(4, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Student student=new Student();
				student.setStuId(rs.getInt("stuid"));
				student.setStuName(rs.getString("stuname"));
				student.setMajor(rs.getString("major"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseConnect();
		}
		return list;
		
	}

	//获取记录总数
	public static int getCount(){
		int totle=0;
		ConnectDBMS();
		String sql="select count(stuid) from student";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				totle=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseConnect();
		}
		return totle;
		
	}
}
