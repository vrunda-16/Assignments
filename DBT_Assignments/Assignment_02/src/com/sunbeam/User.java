package com.sunbeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class User {
	
	static int mainu (Scanner sc) {
		System.out.println("1.Add Student\n2.Display Student\n3.Search Student on roll no\n4.Sort Student on roll no\n5.Sort Student on name\n6.Sort Student on marks\n7.Exit");
		System.out.println("Enter Choice :");
		return sc.nextInt();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> studentList  = new ArrayList<>();
		
		class StdNameComparator implements Comparator<Student> {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
			
		}
		StdNameComparator snc = new StdNameComparator();
		
		class StdMarkComparator implements Comparator<Student> {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.marks.compareTo(o2.marks);
			}
			
		}
		StdMarkComparator smc = new StdMarkComparator();
	
		int ch;
		while((ch = mainu(sc)) != 7 ) {
			switch (ch) {
			case 1:
				
				Student S1 = new Student();
				S1.acceptStudent(sc);
				studentList.add(S1);
				System.out.println("Student added successfully !");
				
				break;
			case 2:
				for (Student S : studentList) {
					System.out.println(S.toString());
				}
				break;
			case 3:
				System.out.println("Enter Roll no :");
				int r = sc.nextInt();
				Student S = new Student(r);
				if(studentList.contains(S))
					System.out.println("Student with roll number "+ r + " found in list.");
				else
					System.out.println("Student not found.");
				break;
			case 4:
				System.out.println("Sort by roll no :");
				Collections.sort(studentList);
				for (Student s : studentList) {
					System.out.println(s.toString());
				}
				break;
			case 5:
				System.out.println("Sort by name :");
				studentList.sort(snc);
				for (Student s : studentList) {
					System.out.println(s.toString());
				}
				break;
			case 6:
				System.out.println("Sort by marks  :");
				studentList.sort(smc);
				for (Student s : studentList) {
					System.out.println(s.toString());
				}
				break;

			default:
				break;
			}
		}
	}

}
