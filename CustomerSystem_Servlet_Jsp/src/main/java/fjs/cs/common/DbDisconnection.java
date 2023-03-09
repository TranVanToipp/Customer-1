package fjs.cs.common;

import java.sql.Connection;
import java.sql.SQLException;

public class DbDisconnection {
	public static void DbDisconnect(Connection connection) {
	    if (connection != null) {
	      try {
	        connection.close(); // Đóng connection
	      } catch (Exception ex) { 
	        System.out.println("Lỗi khi ngắt kết nối với cơ sở dữ liệu: " + ex.getMessage());
	      }
	    }
	  }
}
