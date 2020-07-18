package com.stu;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {

	private static ArrayList<Student> array = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		while (true) {
			
			// Print out the welcome message
			System.out.println("-----Welcome! You've opened the Stu's Student Manage System.-----");
			System.out.println("-----Type numbers to use its corresponding functions:-----  \n"
			+"1: Add a student \n"
			+"2: List all the student \n"
			+"3: Search for a student \n"
			+"4: Delete a student \n"
			+"5: Exit the system");
			
			// Create the Scanner
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			
			switch(choice) {
				
			case "1":
				addStudent();
				break;
			
			case "2":
				listStudent();
				break;
				
			case "3":
				searchStudent();
				break;
				
			case "4":
				deleteStudent();
				break;
				
			case "5":
				System.out.println("Thanks for using my system.");
				// Exit JVM
				System.exit(0);
				break;
				
			default:
				System.out.println("The choice you typed in does not exist.");
				break;
			}
		}
	}
	
	public static void addStudent() {
		
		//Create the Scanner
		Scanner sc = new Scanner(System.in);
		
		String number;
		
		//Ask for the info the student
		while (true) {
			
			System.out.println("What is the number of this student?");
			number = sc.nextLine();
			System.out.println("The number is: "+number);
			
			// Check if this number has been used
			for (int i=0; i < array.size(); i++) {
				Student student = array.get(i);
				
				if (number == student.getNumber()) {
					System.out.println("This number has been used. Please use a different one.");
					break;
				}
			}
			
			// Exit this while loop
			break;
		}
		System.out.println("What is the name of this student?");
		String name = sc.nextLine();
		System.out.println("The name is: "+name);
		System.out.println("What is the age of this student?");
		String age = sc.nextLine();
		System.out.println("The age is: "+age);
		System.out.println("What is the address of this student?");
		String address = sc.nextLine();
		System.out.println("The address is: "+address);
		
		//Create the Student
		Student student = new Student(age, name, number ,address);
		array.add(student);
		
		System.out.println("Successfully added the student.");
		
	}
	
	public static void listStudent() {
		
		// Print out the form of the Student's list
		System.out.println("Number  Name  Age  Address \n");
		
		// Iterate the array to print out the info of all the student
		for (int i=0; i < array.size(); i++) {
			Student student = array.get(i);
			System.out.println(student.getNumber()+"\t"+student.getName()+"\t"+student.getAge()+"\t"+student.getAddress());
			
		}
	}
	
	public static void searchStudent() {
		
		// Check if there's any student
		if (array.size() == 0) {
			System.out.println("There is no student recoreded in this system.");
			return;
		}
		
		// Create the Scanner
		Scanner sc = new Scanner(System.in);
		
		// Ask for the number of the student
		System.out.println("Please type in the number of the student.");
		String number = sc.nextLine();
		
		int index = -1;
		for (int i=0; i < array.size(); i++) {
			Student student = array.get(i);
			
			if (number.equalsIgnoreCase(student.getNumber())) {
				index = i;
				break;
			}
		}
		
		if (index == -1) {
			System.out.println("The target student does not exist.");
		}
		else {
			Student student = array.get(index);
			System.out.println(student.getNumber()+"\t"+student.getName()+"\t"+student.getAge()+"\t"+student.getAddress());
		}
		
	}
	
	public static void deleteStudent() {
		
		// Check if there's any student
		if (array.size() == 0) {
			System.out.println("There is no student recoreded in this system.");
			return;
		}
		
		// Create the Scanner
		Scanner sc = new Scanner(System.in);
		
		// Ask for the number of this student
		System.out.println("Please type in the number of the student.");
		String number = sc.nextLine();
		
		int index = -1;
		for (int i=0; i < array.size(); i++) {
			Student student = array.get(i);
			
			if (number.equalsIgnoreCase(student.getNumber())) {
				index = i;
				break;
			}
		}
		
		if (index == -1) {
			System.out.println("The target student does not exist.");
		}
		else {
			array.remove(index);
			System.out.println("The target student has been deleted.");
		}

	}
}
