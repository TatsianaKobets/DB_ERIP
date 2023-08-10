package by.htp.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JobApplication {

		private static final String url = "jdbc:mysql://127.0.0.1:3306/job_test_db?" +
				"useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
				"&useLegacyDatetimeCode=false&serverTimezone=UTC";
		private static final String user = "root";
		private static final String password = "1111";
		private static Connection connection;
		private static Statement statement;

		public static void main(String[] args) {
			List<String> worker = new ArrayList<String>();

			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader("d:/notes3.txt"));
				String read = null;
				while ((read = in.readLine()) != null) {
					String[] splited = read.split("\\^");

					for (String part : splited) {
						worker.add(part);
					}
					String surname = worker.get(0);
					String name = worker.get(1);
					String lastname = worker.get(2);
					String address = worker.get(3);
					String payment = worker.get(4);
					String paymentdata = worker.get(5);
					String price = worker.get(6);
					String quantity = worker.get(7);
					String sum = worker.get(8);

					try {
						connection = DriverManager.getConnection(url, user, password);
						statement = connection.createStatement();
						String sql = "INSERT Workers" +
								" (surname, name, lastname, address, payment, paymentdata,  price, quantity, sum )" +
								" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?\n)";
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1, surname);
						preparedStatement.setString(2, name);
						preparedStatement.setString(3, lastname);
						preparedStatement.setString(4, address);
						preparedStatement.setString(5, payment);
						preparedStatement.setString(6, paymentdata);
						preparedStatement.setString(7, price);
						preparedStatement.setString(8, quantity);
						preparedStatement.setString(9, sum);
						preparedStatement.executeUpdate();

					} catch (SQLException sqlEx) {
						sqlEx.printStackTrace();
					} finally {
						try {
							connection.close();
						} catch (NullPointerException | SQLException ex) {
							System.out.println("Exception: connection" + ex);
						}
						try {
							statement.close();
						} catch (NullPointerException | SQLException ex) {
							System.out.println("Exception: statement" + ex);
						}
					}
				}

			} catch (
					IOException e) {
				System.out.println("There was a problem: " + e);
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
	}
