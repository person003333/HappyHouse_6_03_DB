package happyhouse.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import happyhouse.DTO.HouseDto;
import happyhouse.jdbc.DBConnection;

public class HouseDaoImpl implements HouseDao {

	private static HouseDao houseDao;

	private HouseDaoImpl() {}

	public static HouseDao getProductDao() {
		if (houseDao == null)
			houseDao = new HouseDaoImpl();
		return houseDao;
	}

	@Override
	public List<HouseDto> searchAll(int guguncode, String dong) {
		List<HouseDto> list = new ArrayList<>();

		try (Connection conn = DBConnection.getConnection();) {

			
			
			String sql = "select dong, AptName, guguncode, buildYear, ";
			sql += "lat, lng \n";
			sql += "from houseinfo\n";
			sql += "where guguncode = ? and dong = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guguncode);
			pstmt.setString(2, dong);	
			try ( ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					HouseDto houseDto = new HouseDto();
					houseDto.setDong(rs.getString("dong"));
					houseDto.setAptName(rs.getString("AptName"));
					houseDto.setGuguncode(rs.getInt("guguncode"));
					houseDto.setBuildYear(rs.getInt("buildYear"));
					houseDto.setLat(rs.getDouble("lat"));
					houseDto.setLat(rs.getDouble("lng"));

					list.add(houseDto);
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
