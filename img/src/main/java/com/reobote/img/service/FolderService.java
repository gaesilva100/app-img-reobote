package com.reobote.img.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.services.drive.model.File;
import com.reobote.img.repository.CreateFolder;
import com.reobote.img.repository.CreateGoogleFile;
import com.reobote.img.repository.FindFilesByName;


@Service
public class FolderService {
	
	@Autowired
	private CreateFolder createFolder;
	
	
	

	// Essa bagaça ta Dando Erro .
	public String folder(String name) throws IOException {
   	 
		String idFolder = createFolder.createGoogleFolder("1B5882v8oW7zcAJuOFhW6c-EE4TleseUU", name);
		System.out.println("Id do diretorio "+idFolder); 
		
		  // Create a Root Folder
       return (idFolder);
             
       
    }




}
