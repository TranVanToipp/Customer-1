package fjs.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fjs.cs.common.DBConnection;
import fjs.cs.common.DbDisconnection;
import fjs.cs.dto.T001Dto;

public class T001Dao {
	public T001Dto checkLogin(String user, String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "select COUNT(*) as CNT from MSTUSER where DELETE_YMD is null and USERID =? and PASSWORD =?";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int count = rs.getInt("CNT");
				if (count == 1) {
					T001Dto resultCount = new T001Dto(user, pass, null);
					return resultCount;
				}else {
					return null;
				}
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
