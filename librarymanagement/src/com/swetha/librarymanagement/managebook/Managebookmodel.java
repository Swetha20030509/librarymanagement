package com.swetha.librarymanagement.managebook;

import java.util.ArrayList;

import com.swetha.librarymanagement.datalayer.Librarydatabase;
import com.swetha.librarymanagement.model.Book;
import com.swetha.librarymanagement.model.GetBook;

public class Managebookmodel {
	private Managebookview managebookview;
	public Managebookmodel(Managebookview managebookview)
	{
		this.managebookview=managebookview;
	}
	public boolean addBook(String bookName, String name,String edition, String publication, int count) {
		Book book=new Book();
		book.setBookName(bookName);
		book.setAuthorName(name);
		book.setBookId();
		book.setEdition(edition);
		book.setPublication(publication);
		book.setAvaibleCount(count);
		return Librarydatabase.getInstance().insertBook(book);
	}

	public boolean removeBook(String bookName) {
		return Librarydatabase.getInstance().removeBook(bookName);
	}

	public ArrayList<Book> search(String name) {
		
		return Librarydatabase.getInstance().searchBook(name);
		
	}
	public ArrayList<Book> getAllBooks() {
		return Librarydatabase.getInstance().getAllBooks();
		
	}
	public Book getBook(String bookName) {
		Book book=Librarydatabase.getInstance().findBook(bookName);
		if(book==null) {
			managebookview.alert("No books available");
			return null;
		}
		return book;
	}
	public void returnBook(Book book)
	{
		if(Librarydatabase.getInstance().returnBook(book)) {
			book.setAvaibleCount(book.getAvailableCount() + 1);
		}
		else {
			managebookview.alert("No record found");
		}
	}

	public void assignGetBook(Book book) {
		Librarydatabase.getInstance().addBorrowedBook(book);
	}

	public ArrayList<GetBook> getBorrowedBook() {
		return Librarydatabase.getInstance().getBorrowedBook();
	}
}
