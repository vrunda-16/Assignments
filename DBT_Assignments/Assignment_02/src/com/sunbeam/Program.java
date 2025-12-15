package com.sunbeam;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		readString str = new readString();
		String s;
		try {
			System.out.println("Enter String :");
			s = sc.next();
			str.setMsg(s);
		}catch(ExceptionLineTooLong e){
			e.printStackTrace();
		}
	}

}
