package com.sunbeam;

import java.util.Scanner;

public class Student implements Comparable<Student>{
	int rollno;
	Integer marks;
	String name;

	public Student(int rollno, int marks, String name) {
		super();
		this.rollno = rollno;
		this.marks = marks;
		this.name = name;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int rollno) {
		super();
		this.rollno = rollno;
	}
	
	void acceptStudent(Scanner sc) {
		System.out.println("Enter roll no :");
		rollno = sc.nextInt();
		System.out.println("Enter name :");
		name = sc.next();
		System.out.println("Enter marks :");
		marks = sc.nextInt();
	}
	
	@Override
	public String toString() {
		return "Student :\nRoll no :" + rollno +"\nName :"+name+"\nMarks :"+marks;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		Student other = (Student) obj;
		return this.rollno == other.rollno;
	}

	@Override
	public int compareTo(Student o) {
		return this.rollno - o.rollno;
	}

}
