package happyhouse.DAO;

import java.util.List;

import happyhouse.DTO.HouseDto;

public interface HouseDao {



	List<HouseDto> searchAll(int guguncode, String dong);

	
}
