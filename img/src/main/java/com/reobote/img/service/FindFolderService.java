package com.reobote.img.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reobote.img.repository.FindFoldersByName;

@Service
public class FindFolderService {
	
	@Autowired
	private FindFoldersByName findFoldersByname;
	@Autowired
	private FolderService folderService;
	
	public String FindFolderServe(String cpnj) throws IOException {
		
		String past = FindFoldersByName.findFolder(cpnj);
		String idFolder;
		if (past != null) {			
			idFolder = past; 
			System.out.println("Achou"+idFolder);
		}else {
			System.out.println("Não Achou");
			String newId = folderService.folderCreateforNameService(cpnj);
			System.out.println(newId+"Não Achou, mais agora criouuuu");
			idFolder = newId;
		}

		
		
		return idFolder;
	}

}
