package com.sunbeam.menu;

import java.util.Scanner;

enum EMainMenu {
	AdminLogin , StudentRegister , StudentLogin , Exit
}

public class MainMenu {	
	
	public static void mainMenuWithEnum (Scanner sc){
		EMainMenu[] arr = EMainMenu.values();
		EMainMenu enumchoice;
		do {
			System.out.println("----------------- Main Menu ------------------");
			for (EMainMenu ele : arr) 
				System.out.println(ele.ordinal() + "." + ele.name());
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			enumchoice = arr[choice];
			switch (enumchoice) {
			case AdminLogin:
				System.out.println("You have selected admin login case.");
				AdminMenu.adminMenuWithEnum(sc);
				break;
			case StudentRegister:
				System.out.println("You have selected student register case.");
				break;
			case StudentLogin:
				System.out.println("You have selected student login case.");
				StudentMenu.studentMenuWithEnum(sc);
				break;
			case Exit:
				System.out.println("Thank you for visiting application.");
				break;
			default:
				System.out.println("Wrong choice.");
				break;
			}
		}while(enumchoice != EMainMenu.Exit);
		
		
	}
}
