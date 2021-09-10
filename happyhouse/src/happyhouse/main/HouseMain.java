package happyhouse.main;
import java.io.*;
import java.util.List;

import happyhouse.DAO.FavoriteDao;
import happyhouse.DAO.FavoriteDaoImpl;
import happyhouse.DAO.HouseDaoImpl;
import happyhouse.DAO.House_dealDaoImpl;
import happyhouse.DAO.UserDaoImpl;

import happyhouse.DTO.FavoriteDto;
import happyhouse.DTO.HouseDto;
import happyhouse.DTO.House_dealDto;
import happyhouse.DTO.UserDto;

public class HouseMain {
	
	BufferedReader in;
	UserDto user;

	public HouseMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		new HouseMain().menu();
	}

	private void menu() {
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 동 조회");
			System.out.println("2. 실거래가 조회");
			System.out.println("3. 로그인");
			System.out.println("4. 회원가입");
			System.out.println("5. 회원정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 회원 조회");
			System.out.println("8. 관심지역 등록");
			System.out.println("9. 관심지역 삭제");
			System.out.println("10. 관심지역 조회");
			System.out.println("0. 종료");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : searchAll();break;
				case 2 : search_deal();break;
				case 3 : login();break;
				case 4 : insert_User();break;
				case 5 : update_User();break;
				case 6 : delete_User();break;
				case 7 : searchAll_User();break;
				case 8 : register_favorite();break;
				case 9 : deleteFavorite();break;
				case 10: search_favorite();break;
				default : isContinue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}
	private void deleteFavorite() {
//		System.out.println("deleteProduct");
		try {
			System.out.println("--------------------- 상품 삭제 ---------------------");
			int user_no = user.getUserno();
			System.out.print("삭제할 동코드 : ");
			int dongcode = Integer.parseInt(in.readLine());
			
			FavoriteDaoImpl.getProductDao().deleteFavorite(user_no, dongcode);
			System.out.println("-------------------------------------------------");
			System.out.println("삭제 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void register_favorite() {
//		System.out.println("register");
//		유효성 검사는 생략할게요!!!
		try {
			System.out.println("--------------------- 등록 ---------------------");
			int user_no = user.getUserno();
			System.out.print("동 코드 : ");
			int dongcode = Integer.parseInt(in.readLine());
			System.out.print("구 : ");
			String gu = in.readLine();
			System.out.print("동 : ");
			String dong = in.readLine();
			
			FavoriteDto favoriteDto = new FavoriteDto();
			favoriteDto.setUser_no(user_no);
			favoriteDto.setDongcode(dongcode);
			favoriteDto.setGu(gu);
			favoriteDto.setDong(dong);
			
			FavoriteDao productDao = FavoriteDaoImpl.getProductDao();
			productDao.register(favoriteDto);
			System.out.println("-------------------------------------------------");
			System.out.println("등록 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void search_favorite() throws NumberFormatException, IOException {
		System.out.println("searchAll");
		int user_no = user.getUserno();

		List<FavoriteDto> list = FavoriteDaoImpl.getProductDao().searchAll(user_no);
		show_favoriteList(list);
	}

	
	private void show_favoriteList(List<FavoriteDto> list) {
		System.out.println("===================================== 관심지역 목록 =====================================");
		System.out.println("user_no\tdongcode\tgu\tdong");
		
		System.out.println("-------------------------------------------------------------------------------------");
		for(FavoriteDto house : list) {
			System.out.println(house);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
	
	private void search_deal() throws NumberFormatException, IOException {
//		System.out.println("searchAll");
		int guguncode = 11110;
		String dong = "사직동";
		String AptName = "광화문풍림스페이스본(101동~105동)";
		System.out.print("구군 코드 입력 : ");
		guguncode = Integer.parseInt(in.readLine());
		System.out.print("동 입력 : ");
		dong = in.readLine();
		List<House_dealDto> list = House_dealDaoImpl.getProductDao().searchAll(guguncode,dong,AptName);
		show_dealList(list);
	}

	
	private void show_dealList(List<House_dealDto> list) {
		System.out.println("===================================== 실거래가 목록 =====================================");
		System.out.println("Name\t\tdealAmount\tdealDate\tarea\t\ttype");
		
		System.out.println("-------------------------------------------------------------------------------------");
		for(House_dealDto house : list) {
			System.out.println(house);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
	
	private void searchAll() throws NumberFormatException, IOException {
//		System.out.println("searchAll");
		int guguncode = 11110;
		String dong = "사직동";
		System.out.print("구군 코드 입력 : ");
		guguncode = Integer.parseInt(in.readLine());
		System.out.print("동 입력 : ");
		dong = in.readLine();
		List<HouseDto> list = HouseDaoImpl.getProductDao().searchAll(guguncode,dong);
		showList(list);
	}
	
	

	private void showList(List<HouseDto> list) {
		System.out.println("===================================== 목록 =====================================");
		System.out.println("동\tName\t구군코드\t건설년\t위도\t경도");
		System.out.println("-------------------------------------------------------------------------------------");
		for(HouseDto house : list) {
			System.out.println(house);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
	private void login() throws IOException {
		System.out.print("사용자 ID 입력 : ");
		String id = in.readLine();
		System.out.print("사용자 비밀번호 입력 : ");
		String password = in.readLine();
		user = UserDaoImpl.getUserDao().login(id, password);
	}
	
	private void insert_User() throws IOException {
		System.out.print("사용자 ID 입력 : ");
		String id = in.readLine();
		System.out.print("사용자 비밀번호 입력 : ");
		String password = in.readLine();
		System.out.print("사용자 이름 입력 : ");
		String name = in.readLine();
		System.out.print("사용자 주소 입력 : ");
		String address = in.readLine();
		System.out.print("사용자 전화번호 입력 : ");
		String tel = in.readLine();
		UserDaoImpl.getUserDao().registerUser(id, password, name, address, tel);
	}
	
	private void update_User() throws IOException {
		if(user != null) {
			System.out.print("비밀번호 변경 : 1번 / 이름 변경 : 2번 / 주소 변경 : 3번 / 전화번호 변경 : 4번");
			String option = in.readLine();
			System.out.print("업데이트 할 정보 입력 : ");
			String updateInfo = in.readLine();
			UserDaoImpl.getUserDao().updateUserInfo(option, user.getUserId(), updateInfo);
		}
	}
	
	private void delete_User() throws IOException {
		System.out.print("삭제 할 사용자 ID 입력 : ");
		String id = in.readLine();
		UserDaoImpl.getUserDao().deleteUser(id);
	}
	
	private void searchAll_User() {
		List<UserDto> userlist = UserDaoImpl.getUserDao().searchAll();
		show_userList(userlist);
	}
	
	private void show_userList(List<UserDto> list) {
		System.out.println("===================================== 유저 목록 =====================================");
		System.out.println("id\t\tpassword\tname\taddress\t\ttel");
		System.out.println("-------------------------------------------------------------------------------------");
		for(UserDto user : list) {
			System.out.println(user);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	} 
}
