package com.sunbeam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcConnection {
	private static final String url = "jdbc:mysql://localhost:3306/internship_db";
	private static final String username = "root";
	private static final String password = "vrunda";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	//select query---- For DQL executeQuery()
	public static void getAllStudent() {
		System.out.println("All students :");
		String sql = "SELECT rollno , name , email , course FROM student";
		try {
			Connection conn = getConnection();
			PreparedStatement selectStatement = conn.prepareStatement(sql);
			ResultSet rs = selectStatement.executeQuery();
			while(rs.next()) {
				int rollno = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String course = rs.getString(4);
				System.out.println("Student [roll no = "+ rollno + ", name =" + name + 
						", emial ="+email+ ", course =" + course + "]");
			}
			conn.close();
			selectStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//insert query---- For DML executeUpdate()
	public static void insertIntoStudent(Scanner sc) {
		System.out.println("Enter name:");
		String name = sc.next();
		System.out.println("Enter email :");
		String email = sc.next();
		System.out.println("Enter course (java , python , mern) :");
		String course = sc.next();
		
		String sql = "insert into student(name , email ,course) values(? , ? ,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement insertStatement = conn.prepareStatement(sql);
			insertStatement.setString(1, name);
			insertStatement.setString(2, email);
			insertStatement.setString(3, course);
			insertStatement.executeUpdate();
			conn.close();
			insertStatement.close();
			System.out.println("Student inserted.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//update query
	public static void updateStudentEmail(Scanner sc) {
		System.out.println("Enter roll no :");
		int rollno = sc.nextInt();
		System.out.println("Enter new mail :");
		String email = sc.next();
		String sql = "update Student set email = ? where rollno = ?";
		try {
			Connection conn = getConnection();
			PreparedStatement updateStatement = conn.prepareStatement(sql);
			updateStatement.setString(1, email);
			updateStatement.setInt(2, rollno);
			updateStatement.executeUpdate();
			System.out.println("Mail updated.");
			conn.close();
			updateStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateStudentName(Scanner sc) {
		System.out.println("Enter roll no :");
		int rollno = sc.nextInt();
		System.out.println("Enter new name :");
		String name = sc.next();
		String sql = "update Student set name = ? where rollno = ?";
		try {
			Connection conn = getConnection();
			PreparedStatement updateStatement = conn.prepareStatement(sql);
			updateStatement.setString(1, name);
			updateStatement.setInt(2, rollno);
			updateStatement.executeUpdate();
			System.out.println("Name updated.");
			conn.close();
			updateStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateStudentCourse(Scanner sc) {
		System.out.println("Enter roll no :");
		int rollno = sc.nextInt();
		System.out.println("Enter new Course :");
		String course = sc.next();
		course = " "+course;
		String sql = "update Student set course = ? where rollno = ?";
		try {
			Connection conn = getConnection();
			PreparedStatement updateStatement = conn.prepareStatement(sql);
			updateStatement.setString(1, course);
			updateStatement.setInt(2, rollno);
			updateStatement.executeUpdate();
			System.out.println("Course updated.");
			conn.close();
			updateStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//delete query
	public static void deleteStudent(Scanner sc) {
		System.out.println("Enter roll no :");
		int rollno = sc.nextInt();
		String sql = "delete from student where rollno = ?";
		try {
			Connection conn = getConnection();
			PreparedStatement deleteStatement= conn.prepareStatement(sql);
			deleteStatement.setInt(1, rollno);
			deleteStatement.executeUpdate();
			System.out.println("Student deleted successfully.");
			conn.close();
			deleteStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
