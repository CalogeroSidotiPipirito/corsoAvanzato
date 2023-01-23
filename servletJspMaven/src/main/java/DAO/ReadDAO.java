package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ReadDAO {

	public static void getByCode(int codice) throws SQLException {

		Connection dbConnection = null;
		// java.sql.PreparedStatement cmd = null;

		try {

			/*
			 * String driver = "com.mysql.jdbc.Driver";
			 * 
			 * Class.forName(driver);
			 */
			
			Class.forName("org.sqlite.JDBC");

			// Connection string
			String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";

			// connection method with connection string, username and password as inputs
			dbConnection = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

			String qry = "SELECT * FROM artists WHERE codice = ?  ";

			// Creation of a PrepareStatement object for execute query
			PreparedStatement cmd = dbConnection.prepareStatement(qry);

			cmd.setInt(1, codice);

			// Query execution and insert result into ResultSet object
			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();// ---> first row
			// --> second row

			// Print the results for row

			int idC;

			idC = res.getInt("ArtistId");

			System.out.println(idC);

			System.out.println(res.getString("Name"));

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {

			e.printStackTrace();
		} finally {


			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
}
