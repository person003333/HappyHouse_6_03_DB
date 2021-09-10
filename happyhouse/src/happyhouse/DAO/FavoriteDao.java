package happyhouse.DAO;

import java.util.List;

import happyhouse.DTO.FavoriteDto;


public interface FavoriteDao {
	void register(FavoriteDto productDto);
	List<FavoriteDto> searchAll(int user_no);
	void deleteFavorite(int uset_no, int dongcode);
}
