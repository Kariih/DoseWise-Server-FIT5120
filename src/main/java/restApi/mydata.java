package restApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class mydata {

	public mydata() {

	}

	public List<MedicineName> dbdata() {
		Connection c = null;
		Statement stmt = null;
		List<MedicineName> list = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://ec2-50-17-194-129.compute-1.amazonaws.com:5432/d77u14h2uju2hh?sslmode=require",
					"tvnuyfdzdivima", "6e7b50e1296b579877dbe888c5f98b9b7fb8d151b7ead1f227b14acebf009d91");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from heroku1");

			while (rs.next()) {
				MedicineName name = new MedicineName(rs.getString("Name"));
				list.add(name);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return list;

	}

}
