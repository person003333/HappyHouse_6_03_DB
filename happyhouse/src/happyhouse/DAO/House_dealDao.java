package happyhouse.DAO;

import java.util.List;

import happyhouse.DTO.House_dealDto;

public interface House_dealDao {



	List<House_dealDto> searchAll(int guguncode, String dong, String AptName);

	
}
