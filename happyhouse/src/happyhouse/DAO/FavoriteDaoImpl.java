package happyhouse.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import happyhouse.DTO.FavoriteDto;
import happyhouse.jdbc.DBConnection;



public class FavoriteDaoImpl implements FavoriteDao{
	
	private static FavoriteDao favoriteDao;

	private FavoriteDaoImpl() {}

	public static FavoriteDao getProductDao() {
		if (favoriteDao == null)
			favoriteDao = new FavoriteDaoImpl();
		return favoriteDao;
	}

	@Override
	public void register(FavoriteDto productDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into favorite (user_no, dongcode, gu, dong)\n"
					+ "values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productDto.getUser_no());
			pstmt.setInt(2, productDto.getDongcode());
			pstmt.setString(3, productDto.getGu());
			pstmt.setString(4, productDto.getDong());

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
	public List<FavoriteDto> searchAll(int user_no) {
		
		List<FavoriteDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select user_no, dongcode, gu, dong\n";
			sql += "from favorite\n";
			sql += "where user_no = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FavoriteDto favoriteDto = new FavoriteDto();
				favoriteDto.setUser_no(rs.getInt("user_no"));
				favoriteDto.setDongcode(rs.getInt("dongcode"));
				favoriteDto.setGu(rs.getString("gu"));
				favoriteDto.setDong(rs.getString("dong"));

				list.add(favoriteDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public void deleteFavorite(int user_no, int dongcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from favorite where  user_no= ? and dongcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_no);
			pstmt.setInt(2, dongcode);

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

	
	
}
