package com.reobote.img.repository;


import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.mongodb.client.result.UpdateResult;
import com.reobote.img.config.GoogleDriveUtils;
import com.reobote.img.service.FolderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;	

@Repository
public class FindFoldersByName {
	

	// com.google.api.services.drive.model.File
	public static final List<File> getGoogleSubFolders(String googleFolderIdParent) throws IOException {

		Drive driveService = GoogleDriveUtils.getDriveService();

		String pageToken = null;
		List<File> list = new ArrayList<File>();

		String query = null;
		if (googleFolderIdParent == null) {
			query = " mimeType = 'application/vnd.google-apps.folder' " //
					+ " and 'root' in parents";
		} else {
			query = " mimeType = 'application/vnd.google-apps.folder' " //
					+ " and '" + googleFolderIdParent + "' in parents";
		}

		do {
			FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
					// Fields will be assigned values: id, name, createdTime
					.setFields("nextPageToken, files(id, name, createdTime)")//
					.setPageToken(pageToken).execute();
			for (File file : result.getFiles()) {
				list.add(file);
			}
			pageToken = result.getNextPageToken();
		} while (pageToken != null);
		//
		return list;
	}




	
	public static String findFolder(String folderName) throws IOException {

		Drive folder = GoogleDriveUtils.getDriveService();
		String pageToken = null;
		String id = null;

		String query = " name contains '" + folderName + "' " //
				+ " and mimeType = 'application/vnd.google-apps.folder' ";

		do {
			FileList result = folder.files().list()
					.setQ(query)
					.setFields("nextPageToken, files(id, name)")
					.setPageToken(pageToken)
					.execute();
			for (File file : result.getFiles()) {
				System.out.printf("Found file: %s (%s)\n",
						file.getName(), file.getId());
				id = file.getId();
			}
			pageToken = result.getNextPageToken();
		} while (pageToken != null);

		return id;
	}





}