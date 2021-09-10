package happyhouse.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import happyhouse.DTO.*;
import happyhouse.jdbc.*;

//DAO : DataBase Access Object
public class CommDaoImpl implements CommDao {

	private static CommDao commDao;
	
	private CommDaoImpl() {}
	
	public static CommDao getCommDao() {
		if (commDao == null) commDao = new CommDaoImpl();
		return commDao;
	}
	
	@Override
	public List<CommDto> searchAll(String guguncode) {
		List<CommDto> list = new ArrayList<>();
		PreparedStatement pstmt;
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "select * \n";
			sql += "from commercial \n";
			sql += "where guguncode = ?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, guguncode); 
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) {
					CommDto comm = new CommDto(rs.getString("name"), rs.getString("branch"), rs.getString("category"), rs.getString("guguncode"), rs.getString("address"), rs.getString("lng"), rs.getString("lat"));
					list.add(comm);
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
