package com.ssr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssr.model.User;
import com.ssr.util.DBUtil;
import com.ssr.util.StringUtil;
/**
 * 用户工具集
 * @author Administrator
 *
 */
public class UserDao {
	/**
	 * 用户登录
	 * @param user
	 */
	public boolean login(User user) {
		if(checkNotEmpty(user)) {
			String sql = "SELECT * FROM user WHERE name = ? AND password = ?";
			DBUtil dbUtil = new DBUtil();
			Connection conn = null;
			try {
				conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPassword());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					return true;
				}else {
					return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					dbUtil.closeConnection(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
		
	}

	/**
	 * 注册新用户
	 * @param user
	 */
	public boolean register(User user) {
		if(checkNotEmpty(user)) {
			if(!checkInDB(user)){
				String sql = "INSERT INTO user(name,password) VALUES(?,?)";
				DBUtil dbUtil = new DBUtil();
				Connection conn = null;
				try {
					conn = dbUtil.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,user.getName());
					pstmt.setString(2,user.getPassword());
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
			}
		}
		return false;
	}
	
	/**
	 * 修改用户密码
	 * @param user
	 */
	public void updatePassword(User user) {
		String sql = "UPDATE user SET password = ? WHERE name = ?";
		DBUtil dbUtil = new DBUtil();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			int len = pstmt.executeUpdate();
			System.out.println(len);
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
	}
	
	/**
	 * 删除用户信息
	 * @param user
	 */
	public void deleteUser(User user) {
		String sql = "DELETE FROM user WHERE name = ?";
		DBUtil dbUtil = new DBUtil();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			int len = pstmt.executeUpdate();
			System.out.println(len);
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
	}
	/**
	 * 检查user信息
	 * @param user
	 * @return 
	 */
	public boolean checkNotEmpty(User user) {
		if(StringUtil.isNotEmpty(user.getName())) {
			if(StringUtil.isNotEmpty(user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	/**
	 * 检查用户名是否存在于用户信息表中
	 * @param user
	 * @return true为用户名已存在于用户信息表中 false为用户名不在用户信息表中
	 */
	public boolean checkInDB(User user) {
		String sql = "SELECT * FROM user WHERE name = ? ";
		DBUtil dbUtil = new DBUtil();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
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

}
