package com.swetha.librarymanagement.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swetha.librarymanagement.datalayer.Librarydatabase;
import com.swetha.librarymanagement.model.User;

public class LoginModel {
	Loginview loginview;
	User currentUser;
	LoginModel(Loginview loginview)
	{
		this.loginview=loginview;
	}
	public boolean isValid(String name,String password)  {
		if(validUser(name))
		{
			if(validPassword(password))
			{
				loginview.showAlert("Login Successfully");
				loginview.onSuccess();
				return true;
			}
		}
			return false;
	}
	public boolean validUser(String name)
	{
		if(name.equals("swetha"))
			return true;
		return false;
	}
	public boolean validPassword(String password)
	{
		if(password.equals("swetha@123"))
			return true;
		return false;
	}
	public User CheckvalidUser(String name, String password) {
		currentUser=Librarydatabase.getInstance().isUser(name,password);
		if(currentUser!=null)
		{
			loginview.showAlert("LOGIN SUCCESSFULLY");
			Librarydatabase.getInstance().updateCurrentUser(currentUser);
			return currentUser;
		}
		else {
			loginview.showAlert("Invalid username and password");
		}
		return null;
		
	}


}
