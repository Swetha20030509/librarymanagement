package com.swetha.librarymanagement.managebook;
import java.util.*;

import com.swetha.librarymanagement.model.Book;
import com.swetha.librarymanagement.model.GetBook;

public class Managebookview {
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
		showMessage(managebookmodel.addBook(bookName,name,edition,publication,count));
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
		System.out.println("     Book Id      |"+"        Book name          |"+"       Author       |"+"        Edition          |"+"      publication      |");
		for(Book book:allBooks)
		{
			System.out.println("       "+book.getId()+"                     "+book.getBookName()+"                     "+book.getAuthorName()+"                  "+book.getEdition()+"                 "+book.getpublication()+"    ");
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
			book.setAvaibleCount(book.getAvailableCount()-1);
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
		System.out.printf("%-15s %-15s %-10s %-10s %-10s\n","UserName","user Email id","BookName","borrow date","returndate","bookIsReturn");
		for(int i=0;i<borrowedBook.size();i++)
		{
		System.out.printf("%-15s %-15s %-10s \n",borrowedBook.get(i).getUser().getName(),borrowedBook.get(i).getUser().getEmail(),borrowedBook.get(i).getBook().getBookName());
		}
	}
	public void alert(String noBooksAvailable) {
		System.out.println(noBooksAvailable);
	}
}


