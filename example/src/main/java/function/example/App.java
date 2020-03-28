package function.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * An example class calling an ODB function.
 *
 */
public class App {
	public static void main(String[] args) {
		String result = null;
		String word = "racecar";
		try {
			result = checkForPalindrome(word);
		} catch (SQLException e) {
			System.out.println("Error encountered: " + e);
			e.printStackTrace();
		}
		System.out.println(result);
	}

	public static Connection getConnection() {
		
		Properties prop = ReadPropertyFile();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("db.URL"), prop.getProperty("db.user"),
					prop.getProperty("db.password"));
			
		} catch (SQLException e) {
			System.out.println("Error encountered: " + e);
			e.printStackTrace();
		}
		return conn;
	}

	public static String checkForPalindrome(String word) throws SQLException {
		String sql = "{? = call CHECKFORPALINDROME(?)}";
		try (Connection conn = getConnection(); java.sql.CallableStatement stmt = conn.prepareCall(sql);) {
			stmt.setString(2, word);
			stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmt.execute();
			String stmtResult = stmt.getString(1);
			return stmtResult;
		}
	}

	private static Properties ReadPropertyFile() {
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream("c:\\config.properties")) {
			prop.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Error encountered: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error encountered: " + e);
			e.printStackTrace();
		}
		return prop;
	}
}
