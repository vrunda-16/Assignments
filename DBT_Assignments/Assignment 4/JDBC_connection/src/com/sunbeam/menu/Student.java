package com.sunbeam.menu;


import java.sql.SQLException;
import java.util.Scanner;
import com.sunbeam.jdbc.JdbcConnection;

enum EStudentMenu{
	displayStudent , insertStudent , updateStudent ,deleteStudent , exit
}
enum EUpdateMenu{
	updateEmail , updateName ,updateCourse , exit
}
public class Student {
	public static void menu(Scanner sc) {
		EStudentMenu[] arr = EStudentMenu.values();
		EStudentMenu enumchoice ;
		do {
			System.out.println("------------- Menu --------------");
			for (EStudentMenu e : arr) {
				System.out.println(e.ordinal() +"." +e.name()); 
			}
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			enumchoice = arr[choice];
			switch (enumchoice) {
			case displayStudent: 
				JdbcConnection.getAllStudent();
				break;
			case insertStudent: 
				JdbcConnection.insertIntoStudent(sc);
			break;
			case updateStudent: 
				updateMenu(sc);
			break;
			case deleteStudent: 
				JdbcConnection.deleteStudent(sc);
			break;
			case exit: 
				System.out.println("Thank for using application."); 
			break;
			
			default:
				break;
			}	
		}while(enumchoice != EStudentMenu.exit);
	}
	
	public static void updateMenu(Scanner sc) {
		EUpdateMenu[] arr1 = EUpdateMenu.values();
		EUpdateMenu enumchoice;
		do {
			System.out.println("------------ Student Update Menu -----------");
			for (EUpdateMenu e : arr1) 
				System.out.println(e.ordinal() +"."+ e.name());
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			enumchoice = arr1[choice];
			switch (enumchoice) {
			case updateName:
				JdbcConnection.updateStudentName(sc);
				break;
			case updateCourse:
				JdbcConnection.updateStudentCourse(sc);
				break;
			case updateEmail:
				JdbcConnection.updateStudentEmail(sc);
				break;
			case exit:
				System.out.println("Exit !!");
				break;
			default:
				break;
			}
		}while(enumchoice != EUpdateMenu.exit);
	}
}
