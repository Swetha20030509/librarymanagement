package com.swetha.librarymanagement.manageuser;

import com.swetha.librarymanagement.datalayer.*;
import com.swetha.librarymanagement.model.*;
import com.swetha.librarymanagement.model.*;

public class ManageUserModel {
	private ManageUserView manageuserview;
	ManageUserModel(ManageUserView manageuserview)
	{
		this.manageuserview=manageuserview;
	}
	public void AddUser(String userName, String emailId,String password) {
		
		User newUser=new User();
		newUser.setUserName(userName);
		newUser.setEmailId(emailId);
		newUser.setPassword(password);
		if(Librarydatabase.getInstance().insertUser(newUser))
		{
			manageuserview.alert("The user addeded successfully");
		}
		else
		{
			manageuserview.alert("This user already exists");
		}
	}
	/*public void borrowBook(String bookName) {
		Book selectbook=Librarydatabase.getInstance().findBook(bookName);
		if(selectbook!=null)
		{
			if(selectbook.getAvailableCount()>0)
			{
				selectbook.setAvaibleCount(selectbook.getAvailableCount()-1);
			}
			else
			{
				manageuserview.alert("No avaible books");
			}
		}
		else
		{
			manageuserview.alert("No avaible books");
		}
		
	}*/

}
