package com.swetha.librarymanagement.manageuser;

import java.util.Scanner;

public class ManageUserView {
	private ManageUserModel manageusermodel;
	//private ManageBookview managebookview;
	public ManageUserView()
	{
		manageusermodel=new ManageUserModel(this);
	}
	public void initAdd() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the user name");
		String userName=sc.nextLine();
		System.out.println("Enter the email id");
		String emailId=sc.nextLine();
		System.out.println("Create password");
		String password=sc.nextLine();
		manageusermodel.AddUser(userName,emailId,password);	
	}
	/*public void menu()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Search for a book");
		System.out.println("2.Borrow a book");
		System.out.println("3.Return a book");
		System.out.println("4.Logout");
		System.out.println("5.Exit");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			
			break;
		case 2:
			System.out.println("Enter the book name");
			String bookName=sc.nextLine();
			//manageusermodel.borrowBook(bookName);
			break;
		}
		
	}*/
	public void alert(String string) {
		System.out.println(string);
	}
}
