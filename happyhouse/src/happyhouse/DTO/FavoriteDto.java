package happyhouse.DTO;

	public class FavoriteDto {

		private int user_no;
		private int dongcode;
		private String dong;
		private String gu;

		public int getUser_no() {
				return user_no;
			}

		public void setUser_no(int user_no) {
				this.user_no = user_no;
			}

		public int getDongcode() {
				return dongcode;
			}

		public void setDongcode(int dongcode) {
				this.dongcode = dongcode;
			}

		public String getDong() {
				return dong;
			}

		public void setDong(String dong) {
				this.dong = dong;
			}

		public String getGu() {
				return gu;
			}

		public void setGu(String gu) {
				this.gu = gu;
			}

		@Override
			public String toString() {
				return "관심지역 정보 [ 동코드 = " + dongcode + ", 동 = " + dong + ", 구군 = " + gu + "]";
			}

	}