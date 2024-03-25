package com.swetha.librarymanagement.model;

public class Book {
	String bookName;
	String authorName;
	private static int nextId=1;
	private int bookId;
	private String publication;
	private String edition;
	//private String journer;
	private int availableCount;
//	private int volume;
	public void setBookName(String bookName) {
		this.bookName=bookName;	
	}
	public void setAuthorName(String authorName) {
		this.authorName=authorName;
	}
	public void setBookId() {
		this.bookId=nextId++;
	}
	public void setEdition(String edition) {
		this.edition=edition;
	}
	public void setPublication(String publication) {
		this.publication=publication;
	}
	public void setAvaibleCount(int count) {
		this.availableCount=count;
	}
	public int getId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}
	public String getEdition() {
		return edition;
	}
	public int getAvailableCount()
	{
		return availableCount;
	}
	public String getpublication() {
		// TODO Auto-generated method stub
		return publication;
	}
}
