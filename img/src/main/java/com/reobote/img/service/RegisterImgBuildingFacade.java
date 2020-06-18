package com.reobote.img.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reobote.img.domain.Image;
import com.reobote.img.repository.ImgRepository;

@Service
public class RegisterImgBuildingFacade {
	
	@Autowired
	private ImageParser imageParser;
	@Autowired
	private FolderService folderService;
	@Autowired
	private FilesService filesService;
	@Autowired
	private BuildingImageService buildingImageService;
	
	
	public ArrayList<String> registerImages (String codigoImovel,MultipartFile []files) throws IOException{
		
		//ArrayList<String> Array = new ArrayList();
		
		String folderId = folderService.folder(codigoImovel);
		List<Image> listImagens = imageParser.parser(files, codigoImovel);
		for (Image image:listImagens) {
			String teste1 = this.filesService.uploadDrive(image, folderId);
			
			
			System.out.println("RegisterImgBuildingFacade "+ teste1);
			
		}
		buildingImageService.addImagensToBuilding("9999999999", codigoImovel, listImagens);
		
		return (null);
		
	}


}
