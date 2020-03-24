package com.ssr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssr.model.User;
import com.ssr.util.DBUtil;
import com.ssr.util.StringUtil;
/**
 * �û����߼�
 * @author Administrator
 *
 */
public class UserDao {
	/**
	 * �û���¼
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
	 * ע�����û�
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
	 * �޸��û�����
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
	 * ɾ���û���Ϣ
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
	 * ���user��Ϣ
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
	 * ����û����Ƿ�������û���Ϣ����
	 * @param user
	 * @return trueΪ�û����Ѵ������û���Ϣ���� falseΪ�û��������û���Ϣ����
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
