package happyhouse.DTO;
// DTO : Data Transfer Object
// VO : Value Object

public class UserDto {

	private String userId;
	private String userPassword;
	private String userName;
	private String userAddress;
	private String userTel;

	public UserDto(String userId, String userPassword, String userName, String userAddress, String userTel) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userTel = userTel;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Override
	public String toString() {
		return userId + "\t\t" + userPassword + "\t\t" + userName
				+ "\t" + userTel + "\t\t" + userAddress;
	}

}
