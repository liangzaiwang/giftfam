package lanqiao.dao;



import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class C3p0Demo {

	public static DataSource getDataSource(){
		ComboPooledDataSource cpds=new ComboPooledDataSource("student");
		return cpds;
	}
}
