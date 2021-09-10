package happyhouse.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import happyhouse.DTO.UserDto;
import happyhouse.jdbc.*;

//DAO : DataBase Access Object
public class UserDaoImpl implements UserDao {

	private static UserDao userDao;
	
	private UserDaoImpl() {}
	
	public static UserDao getUserDao() {
		if (userDao == null) userDao = new UserDaoImpl();
		return userDao;
	}
	
	@Override
	public UserDto login(String userId, String userPassword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDto user;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from user\r\n"
					+ "where id = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String address = rs.getString("addres");
				String tel = rs.getString("tel");
				return user = new UserDto(no,id, password, name, address, tel);
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void registerUser(String userId, String userPassword, String userName, String userAddress, String userTel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into user (id, password, name, addres, tel)\r\n"
					+ "values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, userName);
			pstmt.setString(4, userAddress);
			pstmt.setString(5, userTel);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void updateUserInfo(String option, String userId, String updateInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "update user ";
			switch (option) {
				case "1":
					sql += "set password = ? ";
					sql += "where id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, updateInfo);
					break;
				case "2":
					sql += "set name = ? ";
					sql += "where id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, updateInfo);
					break;
				case "3":
					sql += "set addres = ? ";
					sql += "where id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, updateInfo);
					break;
				case "4":
					sql += "set tel = ? ";
					sql += "where id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, updateInfo);
					break;
			}
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteUser(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from user where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<UserDto> searchAll() {
		List<UserDto> list = new ArrayList<>();

		try (Connection conn = DBConnection.getConnection();) {
			String sql = "select *\n";
			sql += "from user";
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					UserDto user = new UserDto(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("addres"), rs.getString("tel"));
					list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
