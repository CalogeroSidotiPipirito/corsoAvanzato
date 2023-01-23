package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Artista;

public class UpdateDAO {

	public static void update(Artista a) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {

			/*
			 * String driver = "com.mysql.jdbc.Driver";
			 * 
			 * Class.forName(driver);
			 */
			
			Class.forName("org.sqlite.JDBC");

			// Connection string
			String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";

			// Connection method with connection string, username and password as inputs
			dbConnection = DriverManager.getConnection(url);

			String updateTableSQL = "update artists set Name = ? where ArtistId = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, a.getNome());
			cmd.setInt(2, a.getArtistaID());

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");
			
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
