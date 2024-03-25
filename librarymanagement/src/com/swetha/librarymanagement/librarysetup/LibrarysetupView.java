package com.swetha.librarymanagement.librarysetup;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swetha.librarymanagement.Librarymanagement;
import com.swetha.librarymanagement.managebook.Managebookview;
import com.swetha.librarymanagement.manageuser.ManageUserView;
import com.swetha.librarymanagement.model.Library;
public class LibrarysetupView {
	private Librarysetupmodel librarySetupModel;
	private Managebookview managebookview=new Managebookview();
	private ManageUserView manageuserview=new ManageUserView();
	Scanner sc=new Scanner(System.in);
	public LibrarysetupView()
	{
		 librarySetupModel=new Librarysetupmodel(this);
	}
	public void init()  {
		librarySetupModel.startSetup();
	}
	public void initiateSetup() {
		Library library=new Library();
		System.out.println("Enter the library name");
		String libraryName=sc.nextLine();
		System.out.println("Enter the email Id");
		String emailId=sc.nextLine();
		library.setLibraryName(libraryName);
		library.setEmailId(emailId);
		librarySetupModel.create(library);

		
	}
	public void onSetupComplete()  {
		while(true)
		{
		System.out.println("1.Add Book");
		System.out.println("2.Remove Book");
		System.out.println("3.Search Book");
		System.out.println("4.display all books");
		System.out.println("5.Display borrowed books");
		System.out.println("6.Add user");
		System.out.println("7.Return main menu");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			managebookview.initAdd();
		break;
		case 2:
			managebookview.initRemove();
		break;
		case 3:
			managebookview.initSearch();
		break;
		case 4:
			managebookview.initDisplayBook();
		break;
			case 5:
				managebookview.displayBorrowedBooks();
						break;
		case 6:
			manageuserview.initAdd();
			break;
		case 7:
			Librarymanagement.getInstance().mainMenu();
			break;
		}
		}
		
	}
	public void userMenu() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Search for a book");
			System.out.println("2.Borrow a book");
			System.out.println("3.Return a book");
			//System.out.println("4.Logout");
			System.out.println("4.Exit");

			System.out.println("Enter your choice ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:

					break;
				case 2:
					managebookview.borrowBook();
					break;
				case 3:
					managebookview.returnBook();
					break;
				case 4:
					Librarymanagement.getInstance().mainMenu();
					break;
			}
		}
	}

}
