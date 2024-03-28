package com.swetha.librarymanagement.managebook;

import java.util.ArrayList;

import com.swetha.librarymanagement.datalayer.Librarydatabase;
import com.swetha.librarymanagement.model.Book;
import com.swetha.librarymanagement.model.GetBook;
import com.swetha.librarymanagement.model.User;

public class Managebookmodel {
	private Managebookview managebookview;
	public Managebookmodel(Managebookview managebookview)
	{
		this.managebookview=managebookview;
	}
	public boolean addBook(String bookName, String name,String edition, String publication, int count,int id) {
		Book book=new Book();
		book.setBookName(bookName);
		book.setAuthorName(name);
		book.setBookId(id);
		book.setEdition(edition);
		book.setPublication(publication);
		book.setAvailableCount(count);
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
			book.setAvailableCount(book.getAvailableCount() + 1);
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

	public ArrayList<GetBook> getmyBorrowedBook(User user) {
		ArrayList<GetBook> mybook=new ArrayList<>();
		ArrayList<GetBook>allborrowedBook=Librarydatabase.getInstance().getBorrowedBook();
		if(allborrowedBook.size()>0)
		{
			for(int i=0;i<allborrowedBook.size();i++)
			{
				if(allborrowedBook.get(i).getUser().getName().equals(user.getName()))
					mybook.add(allborrowedBook.get(i));
			}
		}
		System.out.println("My"+mybook.size());
		return mybook;
	}


}
