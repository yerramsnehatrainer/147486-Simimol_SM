package bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDetailsServices  {

	Connection con;
	Statement st;
	
	public void createDB() throws SQLException {
		con=ConnectionManager.getConnection();
		st=con.createStatement();
		String createDB="create database bank;";
		st.executeUpdate(createDB);

	}
				
	
	public void createTable() throws SQLException {
		
		con=ConnectionManager.getConnection();
		
		st = con.createStatement();
		String useDB="use bank;";

		st.executeUpdate(useDB);
		String createTable = "Create table customer_details("
				+ "customerId int auto_increment not null,"
				+ "name varchar(30) not null,"
				+ "age int not null,"
				+ "primary key (customerId)"
				+ ");";
		int table=st.executeUpdate(createTable);
		if (table != 0) {
			System.out.println("Something went wrong!!! Please try again...");
		}
		
		con.close();
	}

	public void insert(CustomerDetails cd) throws SQLException {

		con = ConnectionManager.getConnection();
		st = con.createStatement();
		String useDB="use bank;";

		st.executeUpdate(useDB);
		String createTable = "Insert into customer_details (name,age) values"
				+ "('"+cd.getName()+"',"+cd.getAge()+");";
		int record=st.executeUpdate(createTable);
		if (record != 0) {
			System.out.println("\n-----------------Your account registration completed succesfully !!!-------------");
			ResultSet rs = st.executeQuery("Select * from customer_details where name= '"+cd.getName()+"';");
			while(rs.next()) {
				System.out.println("\n=======================================================");
				System.out.println("                 REGISTRATION DETAILS");
				System.out.println("=======================================================");

				System.out.println("\n CustomerId :"+rs.getInt(1)+""
						+ "\n Account Holder : "+rs.getString(2)+""
						+ "\n Age : "+rs.getString(3));
			}
		}
		else {
			System.out.println("Something went wrong!!! Please try again...");
		}
		con.close();


	}
	
	public void displayAll() throws SQLException {
		con = ConnectionManager.getConnection();
		st = con.createStatement();
		String useDB="use bank;";

		st.executeUpdate(useDB);
		ResultSet rs = st.executeQuery("Select * from customer_details;");
		while(rs.next()) {
			System.out.println("\n CustomerId :"+rs.getInt(1)+""
					+ "\n Account Holder : "+rs.getString(2)+""
					+ "\n Age : "+rs.getString(3));
			System.out.println("--------------------------------------");
		}
		
		con.close();
		
	}

}
