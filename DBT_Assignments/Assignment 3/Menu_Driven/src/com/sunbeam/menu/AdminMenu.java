package com.sunbeam.menu;

import java.util.Scanner;

enum EAdminMenu {
	Createquiz , ListQuizzes , Logout 
}

public class AdminMenu {	
	
	public static void adminMenuWithEnum (Scanner sc){
		EAdminMenu[] arr = EAdminMenu.values();
		EAdminMenu enumchoice;
		do {
			System.out.println("----------------- Admin Menu ------------------");
			for ( EAdminMenu ele : arr) 
				System.out.println(ele.ordinal() + "." + ele.name());
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			enumchoice = arr[choice];
			switch (enumchoice) {
			case Createquiz:
				System.out.println("You have selected create quiz case.");
				break;
			case ListQuizzes:
				System.out.println("You have selected list quizzes case.");
				break;
			case Logout:
				System.out.println("Logout successfully.");
				break;
			default:
				System.out.println("Wrong choice.");
				break;
			}
		}while(enumchoice != EAdminMenu.Logout);
		
		
	}
}
