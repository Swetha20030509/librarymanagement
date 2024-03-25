package com.swetha.librarymanagement.datalayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swetha.librarymanagement.model.Book;
import com.swetha.librarymanagement.model.Library;
import com.swetha.librarymanagement.model.User;
import com.swetha.librarymanagement.model.GetBook;
public class Librarydatabase {
	private Library library;
	private User currentUser;
	private static Librarydatabase librarydatabase;
	private static ArrayList<Library> libraries=new ArrayList<>();
	private  ArrayList<Book> allBooks=new ArrayList<>();
	private ArrayList<User> userList=new ArrayList<>();
	private ArrayList<GetBook>borrowedBook=new ArrayList<>();
	ObjectMapper mapper=new ObjectMapper();
	public static Librarydatabase getInstance()
	{

		if(librarydatabase==null)
		{
			librarydatabase=new Librarydatabase();
        }
		return librarydatabase;
	}
	public Library insertLibrary(Library library2){
		this.library = library2;
		this.library.setLibraryId(1);
		//String i=mapper.writeValueAsString(library2);
		return library;
	}
	
	public boolean insertBook(Book book) {
		boolean flag=allBooks.add(book);
        try {
            String i=mapper.writeValueAsString(allBooks);
			mapper.writeValue(new File("C:\\Users\\ELCOT\\IdeaProjects\\librarymanagement\\Book.json"),allBooks);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(allBooks);
		return flag;
		
	}
	public boolean removeBook(String book) {
		for(int i=0;i<allBooks.size();i++)
		{
			if(allBooks.get(i).getBookName().equals(book))
			{
				 allBooks.remove(i);
				 return true;
			}
		}
		return false;
		
	}
	public ArrayList<Book> searchBook(String name) {
		ArrayList<Book> findBook=new ArrayList<>();
		ObjectMapper mapper1=new ObjectMapper();
		String filePath="Book.json";
		ArrayList<Book> searchBook;
		FileReader reader= null;
        try {
            reader = new FileReader(filePath);
			searchBook=mapper1.readValue(reader, new TypeReference<ArrayList<Book>>() {});
			for(Book book :allBooks)
			{
				if(book.getBookName().startsWith(name))
				{
					findBook.add(book);
				}
			}
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return findBook;
	}
	public ArrayList<Book> getAllBooks() {

		ObjectMapper mapper1=new ObjectMapper();
		String filePath="Book.json";
		ArrayList<Book> allBook;
		FileReader reader= null;
        try {
            reader = new FileReader(filePath);
			allBook=mapper1.readValue(reader, new TypeReference<ArrayList<Book>>() {});
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return allBook;
	}
	public boolean insertUser(User newUser) {
		boolean flag=userList.add(newUser);
		try {
            String i=mapper.writeValueAsString(userList);
			mapper.writeValue(new File("C:\\Users\\ELCOT\\IdeaProjects\\librarymanagement\\User.json"),userList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return flag;
	}
	public Book findBook(String bookname) {
		ObjectMapper mapper1=new ObjectMapper();
		String filePath="Book.json";
		ArrayList<Book> books;
        FileReader reader= null;
        try {
            reader = new FileReader(filePath);
			books=mapper1.readValue(reader, new TypeReference<ArrayList<Book>>() {});
			for(Book book :allBooks)
			{
				if(book.getBookName().equals(bookname))
				{
					return book;
				}
			}
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
	}
	public User isUser(String name, String password) {
		ObjectMapper mapper1=new ObjectMapper();
		String filePath="User.json";
		ArrayList<User> userList1;
        try {
			FileReader reader=new FileReader(filePath);
            userList1=mapper1.readValue(reader, new TypeReference<ArrayList<User>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(User user :userList1)
		{
			if(user.getName().equals(name)&&user.getPassword().equals(password))
			{
				return user;
			}
		}
		return null;
	}

	public void addBorrowedBook(Book book) {
		GetBook getBook=new GetBook(book,currentUser);
		borrowedBook.add(getBook);
        try {
            String i=mapper.writeValueAsString(borrowedBook);
			mapper.writeValue(new File("C:\\Users\\ELCOT\\IdeaProjects\\librarymanagement\\borrowedBooks.json"),borrowedBook);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

	public void updateCurrentUser(User currentUser) {
		this.currentUser=currentUser;
	}

	public ArrayList<GetBook> getBorrowedBook() {
		ObjectMapper mapper1=new ObjectMapper();
		String filePath="borrowedBooks.json";
		ArrayList<GetBook> borrowedBooks;
        FileReader reader= null;
        try {
            reader = new FileReader(filePath);
			borrowedBooks=mapper1.readValue(reader, new TypeReference<ArrayList<GetBook>>() {});
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return borrowedBook;
	}
	public boolean returnBook(Book book)
	{
		ObjectMapper mapper1=new ObjectMapper();
		String filePath="borrowedBooks.json";
		ArrayList<GetBook> borrowedBook;
		FileReader reader= null;
		try {
			reader = new FileReader(filePath);
			borrowedBook=mapper1.readValue(reader, new TypeReference<ArrayList<GetBook>>() {});
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (StreamReadException e) {
			throw new RuntimeException(e);
		} catch (DatabindException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		for(int i=0;i<borrowedBook.size();i++)
		{
		if(currentUser.getEmail().equals(borrowedBook.get(i).getUser().getEmail())&&book.getBookName().equals(borrowedBook.get(i).getBook().getBookName())&&!borrowedBook.get(i).getStatus())
		{
			return true;
		}
		}
		return false;
	}
}
