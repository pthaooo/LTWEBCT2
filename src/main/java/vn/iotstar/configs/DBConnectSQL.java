package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import vn.iotstar.models.UserModel;

public class DBConnectSQL {
	private final String serverName = "DESKTOP-QR7DR8F\\SQLEXPRESS";
	private final String dbName = "ltwebct2";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "2710thao";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ";databaseName = " + dbName + ";user=" + userID + ";password=" + password;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + "; databaseName = " + dbName ;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
