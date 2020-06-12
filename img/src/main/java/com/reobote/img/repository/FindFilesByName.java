package com.reobote.img.repository;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.reobote.img.config.GoogleDriveUtils;

@Repository 
public class FindFilesByName {
	
	 // com.google.api.services.drive.model.File
    public final List<File> getGoogleFilesByName(String fileNameLike) throws IOException {
 
        Drive driveService = GoogleDriveUtils.getDriveService();
 
        String pageToken = null;
        List<File> list = new ArrayList<File>();
 
        String query = " name contains '" + fileNameLike + "' " //
                + " and mimeType != 'application/vnd.google-apps.folder' ";
 
        do {
            FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
                    // Fields will be assigned values: id, name, createdTime, mimeType
                    .setFields("nextPageToken, files(id, name, createdTime, mimeType)")//
                    .setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        //
        return list;
    }
 
    //public static void main(String[] args) throws IOException {
    	// Aqui que pesquisa 
      //  List<File> rootGoogleFolders = getGoogleFilesByName("uteis");
      // (File folder : rootGoogleFolders) {
 
       //     System.out.println("Mime Type: " + folder.getMimeType() + " --- Name: " + folder.getName());
      //  }
 
     //   System.out.println("Done!");
  //  }

}
