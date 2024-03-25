package com.swetha.librarymanagement.model;
public class GetBook {
    Book book;
    User user;
    boolean isReturn;
    public GetBook(Book book, User user)
    {
        this.book=book;
        this.user=user;
    }
    public Book getBook()
    {
        return book;
    }
    public User getUser()
    {
        return user;
    }
    public void setStatus()
    {
        isReturn=true;
    }
    public boolean getStatus()
    {
        return isReturn;
    }
}
