package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromDataBAse {

	public static void main(String[] args) throws Throwable {

		// step:1 :--->Register driver/load the mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// step2:- get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinformation", "root", "root");

		// step3:- create SQL statement
		Statement statement = conn.createStatement();
		String Query = "select*from studentinfo";

		// step4:- execute statement/Query
		ResultSet result = statement.executeQuery(Query);

		while (result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));
		}

		// step5:- close the connection
		conn.close();
	}

}
