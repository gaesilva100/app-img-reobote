package com.reobote.img.repository;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.reobote.img.config.GoogleDriveUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CreateFolder {
	
	 public  String createGoogleFolder(String folderIdParent, String folderName) throws IOException {
		 
	        File fileMetadata = new File();
	 
	        fileMetadata.setName(folderName);
	        fileMetadata.setMimeType("application/vnd.google-apps.folder");
	 
	        if (folderIdParent != null) {
	            List<String> parents = Arrays.asList(folderIdParent);
	 
	            fileMetadata.setParents(parents);
	        }
	        Drive driveService = GoogleDriveUtils.getDriveService();
	 
	        // Create a Folder.
	        // Returns File object with id & name fields will be assigned values
	        File file = driveService.files().create(fileMetadata).setFields("id, name").execute();
	 
	        return file.getId();
	    }
	 


}
