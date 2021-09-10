package happyhouse.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import happyhouse.DTO.*;
import happyhouse.jdbc.*;

//DAO : DataBase Access Object
public class HospitalDaoImpl implements HospitalDao {

	private static HospitalDao hospitalDao;
	
	private HospitalDaoImpl() {}
	
	public static HospitalDao getHospitalDao() {
		if (hospitalDao == null) hospitalDao = new HospitalDaoImpl();
		return hospitalDao;
	}
	
	@Override
	public List<HospitalDto> searchAll(String guguncode) {
		List<HospitalDto> list = new ArrayList<>();
		PreparedStatement pstmt;
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "select * \n";
			sql += "from hospital \n";
			sql += "where guguncode = ?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, guguncode); 
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) {
					HospitalDto hospital = new HospitalDto(rs.getString("sido"), rs.getString("gungu"), rs.getString("name"), rs.getString("address"), rs.getString("type"), rs.getString("tel"), rs.getString("guguncode"));
					list.add(hospital);
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
