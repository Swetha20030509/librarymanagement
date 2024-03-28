package com.swetha.librarymanagement.managebook;
import java.util.*;

import com.swetha.librarymanagement.model.Book;
import com.swetha.librarymanagement.model.GetBook;
import com.swetha.librarymanagement.model.User;

public class Managebookview {
	static int id=1;
	private Managebookmodel managebookmodel;
	public Managebookview()
	{
		managebookmodel=new Managebookmodel(this);
	}
	public void initAdd() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book name:");
		String bookName= sc.nextLine();
		System.out.println("Enter the author name");
		String name=sc.nextLine();
		System.out.println("Enter the Edition");
		String edition=sc.next();
		System.out.println("Enter the publication date");
		String publication=sc.next();
		System.out.println("Enter number of copy");
		int count=sc.nextInt();
		showMessage(managebookmodel.addBook(bookName,name,edition,publication,count,id));
		id++;
	}
	public void initRemove() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book id");
		String bookName=sc.nextLine();
		if(managebookmodel.removeBook(bookName))
		{
			System.out.println("this booked is removed");
		}
		else
		{
			System.out.println("this booked does not removed");
		}
		
	}

	public void initSearch() {
		Scanner sc=new Scanner(System.in);
		ArrayList<Book> searchBooks=new ArrayList<>();
		System.out.println("Enter the name");
		String name=sc.nextLine();
		searchBooks=managebookmodel.search(name);
		System.out.println("Book Id      |"+"Book name      |"+"Author     |"+"Edition      |"+"publication      |"+"Available count");
		for(Book book:searchBooks)
		{
			System.out.println(book.getBookName()+"    "+book.getAuthorName()+book.getEdition()+book.getAvailableCount());
		}
	}
	public void initDisplayBook()
	{
		ArrayList<Book> allBooks=new ArrayList<>();
		allBooks=managebookmodel.getAllBooks();
		if(allBooks.size()>0) {
			System.out.println("---------------------------------------------------------------------------------------------------------");
			System.out.printf("%-15s| %-15s| %-15s| %-15s| %-15s| %-5s%n","Book Id" ,"Book name" ,"Author" ,"Edition" ,"publication","Available count");
			System.out.println("--------------------------------------------------------------------------------------------");
			for (Book book : allBooks) {
				System.out.printf("%-15d| %-15s| %-15s| %-15s| %-15s| %-5d%n",book.getBookId(), book.getBookName() ,book.getAuthorName(),book.getEdition(), book.getPublication(),book.getAvailableCount());
				System.out.println("--------------------------------------------------------------------------------------------");
			}
		}
	}
	public void showMessage(boolean flag)
	{
		if(flag)
			System.out.println("New book added Successfully");
		else
			System.out.println("not added");
	}
	public void borrowBook() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book name");
		String bookName=sc.nextLine();
		Book book =managebookmodel.getBook(bookName);
		if(book!=null)
		{
			book.setAvailableCount(book.getAvailableCount()-1);
			managebookmodel.assignGetBook(book);
			System.out.println("Book sucessfully assigned");
		}
	}
	public void returnBook() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book name");
		String bookName= sc.nextLine();
		Book book=managebookmodel.getBook(bookName);
		managebookmodel.returnBook(book);
	}
	public void displayBorrowedBooks() {
		ArrayList<GetBook>borrowedBook=managebookmodel.getBorrowedBook();
		if(borrowedBook.size()>0) {
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.printf("%-15s| %-15s| %-15s| %-15s%n", "Book Id", "Book name", "User Name", "Mobile number", "Email");
			System.out.println("--------------------------------------------------------------------------------------------");
			for (GetBook book : borrowedBook) {
				System.out.printf("%-15d| %-15s| %-15s| %-15s%n", book.getBook().getBookId(), book.getBook().getBookName(), book.getUser().getName(), book.getUser().getEmail());
				System.out.println("--------------------------------------------------------------------------------------------");
			}
		}
	}
	public void alert(String noBooksAvailable) {
		System.out.println(noBooksAvailable);
	}

	public void myBook(User user) {
		System.out.println("88888");
		printMyBook(managebookmodel.getmyBorrowedBook(user));
	}

	private void printMyBook(ArrayList<GetBook> getBooks) {
		System.out.println("hu otiut");
		if(getBooks.size()>0)
		{
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.printf("%-15s| %-15s| %-15s %-10s1%n", "Book Id", "Book name","Author Name","Returnpending");
			System.out.println("-------------------------------------------------------------------------------------");
			for (GetBook book : getBooks) {
				System.out.printf("%-15d| %-15s| %-15s %-10s%n", book.getBook().getBookId(), book.getBook().getBookName(), book.getBook().getAuthorName(),book.getStatus());
				System.out.println("--------------------------------------------------------------------------------------------");
			}
		}
	}
}


