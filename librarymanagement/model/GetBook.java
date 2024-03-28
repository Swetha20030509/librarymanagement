package com.swetha.librarymanagement.model;
public class GetBook {
    Book book;
    User user;
   boolean isReturn;

    public void setBook(Book book)
    {
        this.book=book;
    }
    public void setUser(User user)
    {
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
    public void setStatus(boolean b)
    {
        isReturn=true;
    }
    public boolean getStatus()
    {
        return isReturn;
    }
}
