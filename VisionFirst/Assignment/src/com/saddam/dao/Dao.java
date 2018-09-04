package com.saddam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saddam.bean.CompanyBean;
import com.saddam.bean.RegisterBean;
import com.saddam.db.DbConnection;

public class Dao { 
	
	public static int registerUser(RegisterBean rb) {
		String sql = null;
		Connection con = DbConnection.getConnection();
		int inserted = 0;
		sql = "insert into user1 values(?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, rb.getName());
			pst.setString(2, rb.getEmail());
			pst.setString(3, rb.getMobile());
			pst.setString(4, rb.getPassword());
			pst.setString(5, rb.getUsername());
			pst.setString(6, rb.getRole());

			inserted = pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	public static boolean loginUser(RegisterBean rb){
		String sql = null;
		Connection con = DbConnection.getConnection();
		boolean status=false;
		sql = "select * from user1 where username=? and password=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, rb.getUsername());
			pst.setString(2, rb.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				rb.setRole(rs.getString("role"));
				status = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<CompanyBean> getAllDetails(){
		List<CompanyBean> l = new ArrayList<CompanyBean>();
		String sql = null;
		Connection con = DbConnection.getConnection();
		try {
			sql = "select * from companytable";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				int sno = rs.getInt(1);
				String companyName = rs.getString(2);
				String companyAddress = rs.getString(3);
				String createdBy = rs.getString(4);
				String actions = rs.getString(5); 
				
				CompanyBean cb = new CompanyBean();
				cb.setSno(sno);
				cb.setCompanyName(companyName);
				cb.setCompanyAddress(companyAddress);
				cb.setCreatedBy(createdBy);
				cb.setActions(actions);
				
				l.add(cb);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}
	
	public static List<CompanyBean> getDetailsByName(String name){
		List<CompanyBean> l = new ArrayList<CompanyBean>();
		String sql = null;
		Connection con = DbConnection.getConnection();
		try {
			sql = "select * from companytable where created_by=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				int sno = rs.getInt(1);
				String companyName = rs.getString(2);
				String companyAddress = rs.getString(3);
				String createdBy = rs.getString(4);
				String actions = rs.getString(5); 
				
				CompanyBean cb = new CompanyBean();
				cb.setSno(sno);
				cb.setCompanyName(companyName);
				cb.setCompanyAddress(companyAddress);
				cb.setCreatedBy(createdBy);
				cb.setActions(actions);
				
				l.add(cb);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}
	
	public static List<CompanyBean> getDetailsById(int sno){
		List<CompanyBean> l = new ArrayList<>();
		String sql = null;
		Connection con = DbConnection.getConnection();
		try {
			sql = "select * from companytable where sno=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,sno);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				int sn = rs.getInt("sno");
				String companyName = rs.getString("company_name");
				String createdBy = rs.getString("created_by");
				String companyAddress = rs.getString("company_address");
				String actions = rs.getString("actions"); 
				
				CompanyBean cb = new CompanyBean();
				cb.setSno(sn);
				cb.setCompanyName(companyName);
				cb.setCreatedBy(createdBy);
				cb.setCompanyAddress(companyAddress);
				cb.setActions(actions);
				
				l.add(cb);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}
	
	public static List<CompanyBean> search(String query){
		List<CompanyBean> l = new ArrayList<>();
		String sql = null;
		Connection con = DbConnection.getConnection();
		try {
			sql = "select * from companytable where company_name=? or created_by=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,query);
			pst.setString(2, query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				int sn = rs.getInt("sno");
				String companyName = rs.getString("company_name");
				String createdBy = rs.getString("created_by");
				String companyAddress = rs.getString("company_address");
				String actions = rs.getString("actions"); 
				
				CompanyBean cb = new CompanyBean();
				cb.setSno(sn);
				cb.setCompanyName(companyName);
				cb.setCreatedBy(createdBy);
				cb.setCompanyAddress(companyAddress);
				cb.setActions(actions);
				
				l.add(cb);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}

	public static int addDetails(CompanyBean cb){
		String sql = null;
		Connection con = DbConnection.getConnection();
		int inserted = 0;
		sql = "insert into companytable(company_name, company_address, created_by, actions) values(?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cb.getCompanyName());
			pst.setString(2, cb.getCompanyAddress());
			pst.setString(3, cb.getCreatedBy());
			pst.setString(4, cb.getActions());

			inserted = pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	public static int editDetails(CompanyBean cb){
		String sql = null;
		Connection con = DbConnection.getConnection();
		int inserted = 0;
		sql = "update companytable set company_name=?, company_address=?, created_by=?, actions=? where sno=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cb.getCompanyName());
			pst.setString(2, cb.getCompanyAddress());
			pst.setString(3, cb.getCreatedBy());
			pst.setString(4, cb.getActions());
			pst.setInt(5, cb.getSno());

			inserted = pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	public static int delete(int sno){
		String sql = null;
		Connection con = DbConnection.getConnection();
		int isDeleted = 0;
		sql = "delete from companytable where sno=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sno);
			isDeleted = pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}
	
	public static int approveDetails(int sno){
		String sql = null;
		Connection con = DbConnection.getConnection();
		int inserted = 0;
		sql = "update companytable set actions=? where sno=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "approved");
			pst.setInt(2, sno);

			inserted = pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inserted;
	}
	

}
