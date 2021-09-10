package happyhouse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	
	public static void close(AutoCloseable...autoCloseables) {
		for (AutoCloseable ac : autoCloseables) {
			if(ac!=null) {
				try {
					ac.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
	}
}
