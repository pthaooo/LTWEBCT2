package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				list.add(new UserModel(
				 	rs.getInt("id"),
				    rs.getString("username"),
				    rs.getString("password"),
				    rs.getString("images"),
				    rs.getString("fullname"),
				    rs.getString("email"),
				    rs.getString("phone"),
				    rs.getInt("roleid"), 			   
				    rs.getDate("createDate")));
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		 String sql = "INSERT INTO users (username, password, images, fullname, email, phone, roleid, createDate) "
	              + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	        conn = new DBConnectSQL().getConnection(); 
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getImages());
	        ps.setString(4, user.getFullname());
	        ps.setString(5, user.getEmail());
	        ps.setString(6, user.getPhone());
	        ps.setInt(7, user.getRoleid());
	        ps.setDate(8, new java.sql.Date(user.getCreateDate().getTime()));

	        ps.executeUpdate(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@Override
	public void update(UserModel user) {
	    String sql = "UPDATE users SET password = ? WHERE email = ?";
	    try {
	        conn = new DBConnectSQL().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getPassword());
	        ps.setString(2, user.getEmail());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	public static void main(String[] args) {
		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findByUserName("duma"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public UserModel findByEmail(String email) {
		  String sql = "SELECT * FROM users WHERE email = ?";
		  try {
				conn = new DBConnectSQL().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, email);
				rs = ps.executeQuery();
				while (rs.next()) {
					UserModel user = new UserModel();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setFullname(rs.getString("fullname"));
					user.setPassword(rs.getString("password"));
					user.setImages(rs.getString("images"));
					user.setRoleid(Integer.parseInt(rs.getString("roleid")));
					user.setPhone(rs.getString("phone"));
					user.setCreateDate(rs.getDate("createDate"));
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

	}


}
