package com.reobote.img.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reobote.img.repository.CreateFolder;



@Service
public class FolderService {
	
	@Autowired
	private CreateFolder createFolder;
	
	
	public String folderCreateforNameService(String name) throws IOException {
   	 	String idFolder = createFolder.createGoogleFolder(null, name);
		return (idFolder);
  
    }
	
	public String folderUploadService(String name ,String folder) throws IOException {
   	 	String idFolder = createFolder.createGoogleFolder(folder, null);
		return (idFolder);
  
    }

}
