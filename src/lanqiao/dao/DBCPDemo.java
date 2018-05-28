package lanqiao.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import oracle.net.aso.p;

public class DBCPDemo {

	
	public static DataSource getDataSourceDBCP(){
		DataSource ds=null;
		Properties prop=new Properties();
		
		InputStream in=new DBCPDemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
		try {
			prop.load(in);
			ds=BasicDataSourceFactory.createDataSource(prop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
		
	}
	
	
}
