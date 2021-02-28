/**
 * 
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.model.Employee;

/**
 * @author SAMYUKTHA
 *
 */
public class DbTest {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/organization?useSSL=false";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "pass123";
	public static Connection con;
	public static Statement stmt;

	static {
		getConnection();
		System.out.println("Driver loaded successfully, con, stmt objects available.");

	}

	public static void main(String[] args)  {

		Employee emp = new Employee();
		emp.setEid(101);
		emp.setEname("prem");
		emp.setSalary(45000);
		emp.setAge(28);
		// Create Employee data in DB.
		//create(emp);

		Employee emp2 = new Employee();
		emp2.setEid(108);
		// Retrieve Single Employee data in DB.
		//retrieve(emp2);
		
		Employee emp3 = new Employee();
		emp3.setEid(101);
		emp3.setEname("rajil");
		emp3.setSalary(35000);
		emp3.setAge(26);
		//update - Single Employee data in DB
		//update(emp3);

		Employee emp4 = new Employee();
		emp4.setEid(107);
		delete(emp4);
	}

	public static void getConnection() {

		try {
			Class.forName(DRIVER);
			System.out.println("Driver loaded successfully.");
			if (con == null)
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			if (stmt == null)
				stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void closeConnection() {

		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void create(Employee emp) {

		try {
			stmt.executeUpdate("insert into employee values(" + emp.getEid() + ",'" + emp.getEname() + "',"
					+ emp.getSalary() + "," + emp.getAge() + ")");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		System.out.println("DB Row inserted successfully.");

	}

	public static void retrieve(Employee emp2)  {

		try {
			getConnection();
			ResultSet rs = stmt.executeQuery("select eid, ename, salary, age from employee where eid = " + emp2.getEid() + ";");

			while(rs.next()) {
				System.out.println("DB Row Retrieve details -> "+rs.getInt("eid")+" - "
						+rs.getString("ename")+" - "+rs.getInt("salary")+" - "+rs.getInt("age"));
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		System.out.println("DB Row Retrieved successfully.");

	}

	public static void update(Employee emp3) {
		try {
			getConnection();
			stmt.executeUpdate("update employee SET ename='" + emp3.getEname() + "', salary = " + emp3.getSalary()
					+ ", age=" + emp3.getAge() + " WHERE eid = " + emp3.getEid() + ";");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		System.out.println("DB Row updated successfully.");

	}

	public static void delete(Employee emp)  {
		try {
			getConnection();
			stmt.execute("delete from employee where eid =" + emp.getEid() + ";");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		System.out.println("DB Row deleted successfully.");

	}
}
