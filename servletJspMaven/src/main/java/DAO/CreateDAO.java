package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Artista;

public class CreateDAO {

	public static void insert(Artista a) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			
			//Connect.connect();
			
			/*String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver); */
			
			Class.forName("org.sqlite.JDBC");

			// Connection string
			String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";

			// connection method with connection string, username and password as inputs
			dbConnection = DriverManager.getConnection(url);
			
			System.out.println("Connection to SQLite has been established.");
			

			String updateTableSQL = "INSERT INTO artists(Name) VALUES(?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, a.getNome());
			

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is insert to DBUSER table!");
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
}
