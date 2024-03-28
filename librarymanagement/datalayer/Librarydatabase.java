package com.swetha.librarymanagement.datalayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
	private ArrayList<Library> allLibrary=new ArrayList<>();
	ObjectMapper mapper=new ObjectMapper();
	public void add(Library library)
	{
		allLibrary.add(library);
		writeLibrary();
	}
	public void writeLibrary()
	{
		System.out.println("gsdkv h");
		File file=new File("C:\\Users\\zoho\\IdeaProjects\\librarymanagement\\Library.json");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(file, allLibrary);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void readLibrary()
	{
		String filePath="Library.json";
		File file=new File(filePath);


		if(file.length()==0)
		{
			this.allLibrary=new ArrayList<>();
		}
		else {
			if(!file.exists())
			{
				try {
					file.createNewFile();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			try {
				ObjectMapper mapper1=new ObjectMapper();
				mapper1.enable(SerializationFeature.INDENT_OUTPUT);
				this.allLibrary = mapper1.readValue(file, new TypeReference<ArrayList<Library>>() {
				});
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (StreamReadException e) {
				throw new RuntimeException(e);
			} catch (DatabindException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
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

		return library;
	}
	public void writeBook()
	{
		File file=new File("C:\\Users\\zoho\\IdeaProjects\\librarymanagement\\Book.json");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(file, allBooks);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public boolean insertBook(Book book) {
		boolean flag=allBooks.add(book);
		writeBook();
		book.setBookId(allBooks.size());
		writeBook();
		return flag;
	}
	public boolean removeBook(String book) {
		for(int i=0;i<allBooks.size();i++)
		{
			if(allBooks.get(i).getBookName().equals(book))
			{
				 allBooks.remove(i);
					writeBook();
				 return true;
			}
		}
		return false;
	}
	public void readBook()
	{
		String filePath="Book.json";
		File file=new File(filePath);


		if(file.length()==0)
		{
			this.allBooks=new ArrayList<>();
		}
		else {
			if(!file.exists())
			{
				try {
					file.createNewFile();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			try {
				ObjectMapper mapper1=new ObjectMapper();
				mapper1.enable(SerializationFeature.INDENT_OUTPUT);
				this.allBooks = mapper1.readValue(file, new TypeReference<ArrayList<Book>>() {
				});
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (StreamReadException e) {
				throw new RuntimeException(e);
			} catch (DatabindException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public ArrayList<Book> searchBook(String name) {
		ArrayList<Book> findBook=new ArrayList<>();
		readBook();
		for(Book book :allBooks)
		{
			if(book.getBookName().startsWith(name))
			{
				findBook.add(book);
			}
		}
        return findBook;
	}
	public ArrayList<Book> getAllBooks() {
		readBook();
        return allBooks;
	}
	public void writeUser(){
	File file=new File("C:\\Users\\zoho\\IdeaProjects\\librarymanagement\\User.json");
		if(!file.exists()) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
		mapper.writeValue(file, userList);
	} catch (JsonProcessingException e) {
		throw new RuntimeException(e);
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
}
	public void readUser()
	{
		String filePath="User.json";
		File file=new File(filePath);
		if(file.length()==0)
		{
			this.userList=new ArrayList<>();
		}
		else {
			if(!file.exists())
			{
				try {
					file.createNewFile();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			try {
				ObjectMapper mapper1=new ObjectMapper();
				mapper1.enable(SerializationFeature.INDENT_OUTPUT);
				this.userList = mapper1.readValue(file, new TypeReference<ArrayList<User>>() {
				});
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public boolean insertUser(User newUser) {
		boolean flag=userList.add(newUser);
		writeUser();
        return flag;
	}
	public Book findBook(String bookname) {
		readBook();
			for(Book book :allBooks)
			{
				if(book.getBookName().equals(bookname))
				{
					return book;
				}
			}
        return null;
	}
	public User isUser(String name, String password) {
	readUser();
        for(User user :userList)
		{
			if(user.getName().equals(name)&&user.getPassword().equals(password))
			{
				return user;
			}
		}
		return null;
	}

	public void addBorrowedBook(Book book) {
		GetBook getBook=new GetBook();
		getBook.setBook(book);
		getBook.setUser(currentUser);
		getBook.setStatus(true);
		System.out.println(borrowedBook.size());
		borrowedBook.add(getBook);
		writeBorrwed();
		System.out.println(borrowedBook.size());
    }
	public void writeBorrwed(){
		File file=new File("C:\\Users\\zoho\\IdeaProjects\\librarymanagement\\BorrowedBooks.json");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(file, borrowedBook);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void readBorrowed()
	{
		String filePath="BorrowedBooks.json";
		File file=new File(filePath);
		if(file.length()==0)
		{
			this.borrowedBook=new ArrayList<>();
	}
	else {
			if(!file.exists())
			{
				try {
					file.createNewFile();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			try {
				ObjectMapper mapper1=new ObjectMapper();
				mapper1.enable(SerializationFeature.INDENT_OUTPUT);
				this.borrowedBook = mapper1.readValue(file, new TypeReference<ArrayList<GetBook>>() {
				});
				System.out.println("123"+borrowedBook.size());
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public void updateCurrentUser(User currentUser) {
		this.currentUser=currentUser;
	}

	public ArrayList<GetBook> getBorrowedBook() {
		//readBorrowed();
		System.out.println(borrowedBook.size());
        return borrowedBook;
	}
	public boolean returnBook(Book book)
	{
		readBorrowed();
		if(borrowedBook.size()>0) {
			for (int i = 0; i < borrowedBook.size(); i++) {
				if (currentUser.getEmail().equals(borrowedBook.get(i).getUser().getEmail()) && book.getBookName().equals(borrowedBook.get(i).getBook().getBookName())) {
					return true;
				}
			}
		}
		return false;
	}

	public ArrayList<Library> getLibrary() {
		return allLibrary;
	}
}
