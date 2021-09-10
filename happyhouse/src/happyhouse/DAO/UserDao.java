package happyhouse.DAO;

import java.util.*;

import happyhouse.DTO.UserDto;

public interface UserDao {
	UserDto login(String userId, String userPassword);
	
	void registerUser(String userId, String userPassword, String userName, String userAddress, String userTel);
	
	void updateUserInfo(String option, String userId, String updateInfo);
	
	void deleteUser(String userId);
	
	List<UserDto> searchAll();
}
