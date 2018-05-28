package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	private static final String DRIVER="oracle.jdbc.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USERNAME="scott";
	private static final String PASSWORD="tiger";
	
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			try {
				conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			return conn;
		}
		
	}
	
	public PreparedStatement getPreparedStatement(String sql,Connection conn) {
			PreparedStatement pstmt = null;
		try {
				pstmt =  conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pstmt;
	}
	public static void  closeAll(ResultSet rs ,PreparedStatement pstmt ,Connection conn) {
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
	
	//增删改
	public static boolean updateMethod(String sql,Object[] objs) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = getConnection();
			 pstmt =conn.prepareStatement(sql);
			if(objs != null) {
				for(int i =0;i<objs.length;i++) {
					
					pstmt.setObject(i+1, objs[i]);
				}
			}
			int result = pstmt.executeUpdate();
			if(result >0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
			return false;
	}
	
	
	
	//查
	public static ResultSet queryMethod(String sql,Object[] objs) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
		if(objs != null) {
			for(int i =0;i<objs.length;i++) {
				pstmt.setObject(i+1, objs[i]);
			}
		}
		 rs = pstmt.executeQuery();
		return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return rs;
	}
	}
}
