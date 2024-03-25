package com.swetha.librarymanagement.login;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swetha.librarymanagement.librarysetup.*;
import com.swetha.librarymanagement.model.Library;

public class Loginview {
	Scanner sc=new Scanner(System.in);
	LoginModel loginmodel;
	LibrarysetupView librarysetupView;
	public Loginview()
	{
		loginmodel =new LoginModel(this);
		librarysetupView=new LibrarysetupView();
	}
	public void init()  {
		System.out.println("Enter the userName");
		String name=sc.nextLine();
		System.out.println("Enter the password");
		String password=sc.nextLine();
		if(!loginmodel.isValid(name,password))
		{
			if(loginmodel.CheckvalidUser(name,password)!=null)
			{
				librarysetupView.userMenu();
			}
		}
	}
	public void showAlert(String message)
	{
		System.out.println(message);
	}
	public void onSuccess() {
		librarysetupView.init();
		
	}
	
}
