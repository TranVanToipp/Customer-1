package fjs.cs.common;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.jasper.tagplugins.jstl.core.Catch;

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(Constants.DB_DRIVER);
			con = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
