package fjs.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fjs.cs.common.DBConnection;
import fjs.cs.common.DbDisconnection;
import fjs.cs.dto.T002Dto;

public class T002Dao {
	public List<T002Dto> getData() {
		List<T002Dto> list = new ArrayList<T002Dto>();
		try {
			String query = "SELECT CUSTOMER_ID, CUSTOMER_NAME,\r\n" + 
					"CASE WHEN SEX = 0 THEN 'Male' ELSE 'Female' END AS SEX,BIRTHDAY, ADDRESS\r\n" + 
					"FROM MSTCUSTOMER WHERE DELETE_YMD IS NULL ORDER BY CUSTOMER_ID";
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				T002Dto dataT002 = new T002Dto();
				dataT002.setCUSTOMER_ID(rs.getString(1));
				dataT002.setCUSTOMER_NAME(rs.getString(2));
				dataT002.setSEX(rs.getString(3));
				dataT002.setBIRTHDAY(rs.getString(4));
				dataT002.setADDRESS(rs.getString(5));
				list.add(dataT002);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<T002Dto> getDataSearch(String name, String sex, String birthdayFrom, String birthdayTo) {
	    List<T002Dto> listSearch = new ArrayList<T002Dto>();
	    Connection conn = null;
	    try {
	        String query = "SELECT CUSTOMER_ID, CUSTOMER_NAME, CASE WHEN SEX = 0 THEN 'Male' else 'Female' end as SEX, BIRTHDAY, ADDRESS \r\n"
	                + "FROM MSTCUSTOMER\r\n"
	                + "WHERE 1=1 ";
	        if (name != null && !name.isEmpty()) {
	            query += "AND CUSTOMER_NAME LIKE ? ";
	        }
	        if (sex != null && !sex.isEmpty()) {
	            query += "AND SEX = ? ";
	        }
	        if (birthdayFrom != null && !birthdayFrom.isEmpty()) {
	            query += "AND BIRTHDAY >= ? ";
	        }
	        if (birthdayTo != null && !birthdayTo.isEmpty()) {
	            query += "AND BIRTHDAY <= ? ";
	        }
	        query += "ORDER BY CUSTOMER_ID;\r\n";
	       
	        conn =  new DBConnection().getConnection();
	        PreparedStatement ps = conn.prepareStatement(query);
	        int parameterIndex = 1;
	        if (name != null && !name.isEmpty()) {
	            ps.setString(parameterIndex++, "%" + name + "%");
	        }
	        if (sex != null && !sex.isEmpty()) {
	            ps.setString(parameterIndex++, sex);
	        }
	        if (birthdayFrom != null && !birthdayFrom.isEmpty()) {
	            ps.setString(parameterIndex++, birthdayFrom);
	        }
	        if (birthdayTo != null && !birthdayTo.isEmpty()) {
	            ps.setString(parameterIndex++, birthdayTo);
	        }
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	            T002Dto dataT002Search = new T002Dto();
	            dataT002Search.setCUSTOMER_ID(rs.getString(1));
	            dataT002Search.setCUSTOMER_NAME(rs.getString(2));
	            dataT002Search.setSEX(rs.getString(3));
	            dataT002Search.setBIRTHDAY(rs.getString(4));
	            dataT002Search.setADDRESS(rs.getString(5));
	            listSearch.add(dataT002Search);
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listSearch;
	}


	
	public List<T002Dto> deleteData(String[] selecValue) {
	    List<T002Dto> listDelete = new ArrayList<T002Dto>();
	    Connection conn = null;
	    try {
	        String query = "UPDATE MSTCUSTOMER "
	                     + "SET Delete_YMD = CURRENT_TIMESTAMP "
	                     + "WHERE customer_Id IN (";
	        for (int i = 0; i < selecValue.length; i++) {
	        	String[] ids = selecValue[0].split(",");
	        	System.out.print(ids);
	            for (int j = 0; j < ids.length; j++) {
	                query += "?,";
	            }
	        }
	        query = query.substring(0, query.length() - 1) + ")";
	        conn = new DBConnection().getConnection();
	        PreparedStatement ps = conn.prepareStatement(query);
	        for (int i = 0; i < selecValue.length; i++) {
	            ps.setLong(i + 1, Long.parseLong(selecValue[i]));
	        }
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listDelete;
	}
	
	
	public int getDataPage() {
		String query = "select count(*) from mstcustomer";
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<T002Dto> pagingData(int index) {
		List<T002Dto> list = new ArrayList<>();
		Connection conn = null;
		//sql
		//select * from mstcustomer order by CUSTOMER_ID OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY
		String query = "SELECT * FROM mstcustomer ORDER BY CUSTOMER_ID LIMIT ?, 3";
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*3);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				T002Dto datapagin = new T002Dto();
				datapagin.setCUSTOMER_ID(rs.getString(1));
				datapagin.setCUSTOMER_NAME(rs.getString(2));
				datapagin.setSEX(rs.getString(3));
				datapagin.setBIRTHDAY(rs.getString(4));
				datapagin.setADDRESS(rs.getString(5));
	            list.add(datapagin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
