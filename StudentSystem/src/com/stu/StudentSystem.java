package com.stu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "StudentInfo.txt";
		
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
				addStudent(fileName);
				break;
			
			case "2":
				listStudent(fileName);
				break;
				
			case "3":
				searchStudent(fileName);
				break;
				
			case "4":
				deleteStudent(fileName);
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
	
	/*
	 * Add a student based on the user input into the student.txt
	 */
	public static void addStudent(String fileName) throws IOException {
		
		// Create the array
		ArrayList<Student> array = new ArrayList<Student>();
		
		// Read data from fileName into the array
		readFile(fileName, array);
		
		// Create the Scanner
		Scanner sc = new Scanner(System.in);
		
		String id;
		
		// Ask for the info the student	
		while (true) {
			
			boolean used = false;
			System.out.println("What is the id of this student?");
			id = sc.nextLine();
			
			// Check if this number has been used
			for (int i=0; i < array.size(); i++) {
				Student student = array.get(i);
				
				if (id.equalsIgnoreCase(student.getId())) {
					System.out.println("This id has been used. Please use a different one.");
					used = true;
					break;
				}
				
			}
			
			// If this id has not been used, exit the while loop
			if (!used) {
				break;
			}	
			
		}
		System.out.println("What is the name of this student?");
		String name = sc.nextLine();
		
		System.out.println("What is the age of this student?");
		String age = sc.nextLine();
		
		System.out.println("What is the address of this student?");
		String address = sc.nextLine();
		
		
		// Create the Student
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setAddress(address);
		student.setId(id);
		array.add(student);
		
		System.out.println("Successfully added the student.");
		
		// Write the info back to the file
		writeFile(fileName, array);
	}
	
	
	/*
	 * List all the student in this system
	 */
	public static void listStudent(String fileName) throws IOException {
		// Create the array
		ArrayList<Student> array = new ArrayList<Student>();
		
		// Read data from fileName into the array
		readFile(fileName, array);
				
		// Print out the form of the Student's list
		System.out.println("Number\tName\tAge\tAddress");
		
		// Iterate the array to print out the info of all the student
		for (int i=0; i < array.size(); i++) {
			Student student = array.get(i);
			System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getAge()+"\t"+student.getAddress());
			
		}
	}
	
	/*
	 * Search a student in this system
	 */
	public static void searchStudent(String fileName) throws IOException {
		
		// Create the array
		ArrayList<Student> array = new ArrayList<Student>();
		
		// Read data from fileName into the array
		readFile(fileName, array);
				
		// Check if there's any student
		if (array.size() == 0) {
			System.out.println("There is no student recoreded in this system.");
			return;
		}
		
		// Create the Scanner
		Scanner sc = new Scanner(System.in);
		
		// Ask for the number of the student
		System.out.println("Please type in the number of the student.");
		String id = sc.nextLine();
		
		int index = -1;
		for (int i=0; i < array.size(); i++) {
			Student student = array.get(i);
			
			if (id.equalsIgnoreCase(student.getId())) {
				index = i;
				break;
			}
		}
		
		if (index == -1) {
			System.out.println("The target student does not exist.");
		}
		else {
			Student student = array.get(index);
			System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getAge()+"\t"+student.getAddress());
		}
		
	}
	
	/*
	 * Delete a student from this system
	 */
	public static void deleteStudent(String fileName) throws IOException {
		
		// Create the array
		ArrayList<Student> array = new ArrayList<Student>();
		
		// Read data from fileName into the array
		readFile(fileName, array);
				
		// Check if there's any student
		if (array.size() == 0) {
			System.out.println("There is no student recoreded in this system.");
			return;
		}
		
		// Create the Scanner
		Scanner sc = new Scanner(System.in);
		
		// Ask for the number of this student
		System.out.println("Please type in the number of the student.");
		String id = sc.nextLine();
		
		int index = -1;
		for (int i=0; i < array.size(); i++) {
			Student student = array.get(i);
			
			// Iterate through the array to find the target student
			if (id.equalsIgnoreCase(student.getId())) {
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
		
		// Write the array back into the fileName
		writeFile(fileName, array);

	}
	
	/*
	 * Write the data from the array into the fileName
	 */
	public static void writeFile(String fileName, ArrayList<Student> array) throws IOException {
		
		// Create the BufferedWriter
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		
		// Iterate the array to write the student'info into the file
		for (int i=0; i<array.size(); i++) {
			Student s = array.get(i);
			StringBuilder info = new StringBuilder();
			// Id,Name,Age,Address
			info.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getAddress());
			bw.write(info.toString());
			bw.newLine();
			bw.flush();
			
		}
		
		// Close the BufferedWriter
		bw.close();
	}
	
	/*
	 * Read the data from the fileName into array
	 */
	public static void readFile(String fileName, ArrayList<Student> array) throws IOException{
		
		// Create the BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// Read the file line by line till the end
		String line;
		while((line = br.readLine()) != null) {
			String[] data = line.split(",");
			Student student = new Student();
			student.setId(data[0]);
			student.setName(data[1]);
			student.setAge(data[2]);
			student.setAddress(data[3]);
			array.add(student);
		}
		
		// Close the BufferedReader
		br.close();
	}
}
