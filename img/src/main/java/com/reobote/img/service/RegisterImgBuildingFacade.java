package com.reobote.img.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reobote.img.domain.Image;

@Service
public class RegisterImgBuildingFacade {
	
	@Autowired
	private ImageParser imageParser;
	@Autowired
	private FolderService folderService;
	@Autowired
	private FilesService filesService;
	
	public List<Image> registerImages (String codigoImovel,MultipartFile []files) throws IOException{
		 	
		String folderId = folderService.folder(codigoImovel);
		List<Image> listImagens = imageParser.parser(files, codigoImovel);
		for (Image image:listImagens) {
			this.filesService.uploadDrive(image, folderId);
		}
		
		return (listImagens);
		
	}


}
