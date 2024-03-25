package com.swetha.librarymanagement;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swetha.librarymanagement.login.Loginview;
public class Librarymanagement {
	 private static Librarymanagement  librarymanagement;
	Loginview loginview;
	Librarymanagement()
	{
		loginview=new Loginview();
	}
	public static Librarymanagement getInstance()
	{
		if(librarymanagement==null)
		librarymanagement=new Librarymanagement(); 
	return librarymanagement;
	}
	public void mainMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.Sign In");
			System.out.println("2.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					loginview.init();
					break;
				case 2:
					System.exit(0);
					break;
			}
		}
	}
	public static void main(String[] args)  {
		getInstance().mainMenu();
		
	}
}
