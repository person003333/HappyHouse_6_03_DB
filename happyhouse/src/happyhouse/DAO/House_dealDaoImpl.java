package happyhouse.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import happyhouse.DTO.House_dealDto;
import happyhouse.jdbc.DBConnection;


public class House_dealDaoImpl implements House_dealDao {

	private static House_dealDao house_dealDao;

	private House_dealDaoImpl() {}

	public static House_dealDao getProductDao() {
		if (house_dealDao == null)
			house_dealDao = new House_dealDaoImpl();
		return house_dealDao;
	}

	@Override
	public List<House_dealDto> searchAll(int guguncode, String dong, String AptName) {
		List<House_dealDto> list = new ArrayList<>();

		try (Connection conn = DBConnection.getConnection();) {

			
			
			String sql = "select dong, AptName, guguncode,dealAmount, ";
			sql += "dealYear, dealMonth, dealDay,";
			sql += "area, type \n";
			sql += "from housedeal\n";
			sql += "where guguncode = ? and dong = ? and AptName = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guguncode);
			pstmt.setString(2, dong);
			pstmt.setString(3, AptName);
			
			try ( ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					House_dealDto house_dealDto = new House_dealDto();
					house_dealDto.setAptName(rs.getString("AptName"));
					house_dealDto.setDealAmount(rs.getString("dealAmount"));
					house_dealDto.setDealYear(Integer.parseInt(rs.getString("dealYear")));
					house_dealDto.setDealMonth(Integer.parseInt(rs.getString("dealMonth")));
					house_dealDto.setDealday(Integer.parseInt(rs.getString("dealDay")));
					house_dealDto.setArea(Float.parseFloat(rs.getString("area")));
					house_dealDto.setType(Integer.parseInt(rs.getString("type")));
					
					
	

					list.add(house_dealDto);
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
