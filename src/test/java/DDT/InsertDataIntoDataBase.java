package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable {

		// step:1 :--->Register driver/load the mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// step2:- get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinformation", "root", "root");

		// step3:- create SQL statement
		Statement statement = conn.createStatement();
		String query = "insert into studentinfo(id,first_name,last_name,address)values('3','ram','sam','goa')";

		int result = statement.executeUpdate(query);

		if (result == 1) {
			System.out.println("Data is created");
		} else {
			System.out.println("Data is not created");
		}
		conn.close();

	}

}
