package com.swetha.librarymanagement.librarysetup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swetha.librarymanagement.datalayer.Librarydatabase;
import com.swetha.librarymanagement.model.Library;

public class Librarysetupmodel {
	private LibrarysetupView librarySetupView;
	private Library library;
	Librarysetupmodel(LibrarysetupView librarySetupView)
	{
		this.librarySetupView=librarySetupView;
	}
	public void startSetup() {
		if (library == null) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete();
		}
	}
	public void create(Library library2)  {
		Librarydatabase library1=Librarydatabase.getInstance();
		if(library1!=null) {
			this.library = Librarydatabase.getInstance().insertLibrary(library2);
		}
		librarySetupView.onSetupComplete();
	}

}
