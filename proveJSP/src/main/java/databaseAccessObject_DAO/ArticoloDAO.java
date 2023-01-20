package databaseAccessObject_DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Articolo;

public class ArticoloDAO {

	public void insert(Articolo a) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Connection string
			String url = "jdbc:mysql://localhost:3306/esercizioarticoliservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// connection method with connection string, username and password as inputs
			dbConnection = DriverManager.getConnection(url, "root", "123456");

			String updateTableSQL = "INSERT INTO articolo(descrizione, quantita) VALUES(?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, a.getDescrizione());
			cmd.setInt(2, a.getQuantita());

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is insert to DBUSER table!");

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

	public void update(Articolo a) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Connection string
			String url = "jdbc:mysql://localhost:3306/esercizioarticoliservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Connection method with connection string, username and password as inputs
			dbConnection = DriverManager.getConnection(url, "root", "123456");

			String updateTableSQL = "update articolo set descrizione = ? where codice = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, a.getDescrizione());
			cmd.setInt(2, a.getCodice());

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

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

	public void delete(int codice) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Connection string
			String url = "jdbc:mysql://localhost:3306/esercizioarticoliservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Connection method with connection string, username and password as inputs
			dbConnection = DriverManager.getConnection(url, "root", "123456");

			String updateTableSQL = "delete from articolo where codice = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, codice);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is deleted to DBUSER table!");

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

	public void getByCode(int codice) {
		try {
			
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Connection string
			String url = "jdbc:mysql://localhost:3306/esercizioarticoliservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Connection method with connection string, username and password as inputs
			Connection dbConnection = DriverManager.getConnection(url, "root", "123456");

			String qry = "SELECT * FROM articolo WHERE codice = ?  ";

			// Creation of a PrepareStatement object for execute query
			PreparedStatement cmd = dbConnection.prepareStatement(qry);

			cmd.setInt(1, codice);

			// Query execution and insert result into ResultSet object
			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();// ---> first row
			// --> second row

			// Print the results for row

			int idC;

			idC = res.getInt("codice");

			System.out.println(idC);

			System.out.println(res.getString("descrizione"));
			System.out.println(res.getInt("quantita"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Articolo> getAll() {
		List<Articolo> listaArticoli = new ArrayList<>();
		try {
		
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Connection string
			String url = "jdbc:mysql://localhost:3306/esercizioarticoliservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Connection method with connection string, username and password as inputs
			Connection dbConnection = DriverManager.getConnection(url, "root", "123456");

			String qry = "SELECT * FROM articolo ";

			PreparedStatement cmd = dbConnection.prepareStatement(qry);

			
			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();// ---> first row
			// --> second row

			// Print results for row
			while (esiste) {
				Articolo a = new Articolo();
				int idC;

				idC = res.getInt("codice");

				System.out.println(idC);

				System.out.println(res.getString("descrizione"));
				System.out.println(res.getInt("quantita"));
				a.setCodice(idC);
				a.setDescrizione(res.getString("descrizione"));
				a.setQuantita(res.getInt("quantita"));

				listaArticoli.add(a);
				esiste = res.next();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaArticoli;
	}

}