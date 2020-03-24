package com.ssr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssr.model.Goods;
import com.ssr.util.DBUtil;

public class GoodsDao {
	public boolean insert(Goods goods) {
		String sql = "INSERT INTO goods(name,price,brand,sort,decs) VALUES(?, ?, ?, ?, ?)";
		DBUtil dbUtil = new DBUtil();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getName());
			pstmt.setDouble(2, goods.getPrice());
			pstmt.setString(3, goods.getBrand());
			pstmt.setString(4, goods.getSort());
			pstmt.setString(5, goods.getDecs());
			int len = pstmt.executeUpdate();
			if(len > 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean delete(Goods goods) {
		String sql = "DELETE FROM goods WHERE name = ?";
		DBUtil dbUtil = new DBUtil();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getName());
			int len = pstmt.executeUpdate();
			if(len > 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean update(Goods goods) {
		String sql = "UPDATE goods SET price = ?, brand = ?, sort = ?, decs = ? WHERE name = ?";
		DBUtil dbUtil = new DBUtil();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, goods.getPrice());
			pstmt.setString(2, goods.getBrand());
			pstmt.setString(3, goods.getSort());
			pstmt.setString(4, goods.getDecs());
			pstmt.setString(5, goods.getName());
			int len = pstmt.executeUpdate();
			if(len > 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}
	public ResultSet select(Connection conn) {
		String sql = "SELECT * FROM goods";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
