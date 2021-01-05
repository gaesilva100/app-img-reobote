package com.reobote.img.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.reobote.img.domain.Image;
import com.reobote.img.repository.FindFoldersByName;


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

	
	@Autowired
	private FindFolderService findFolderService;

	public String  registerImages (String cpnj,String codigoImovel,MultipartFile []files) throws IOException{

		
		
		String idFolder = findFolderService.FindFolderServe(cpnj);

		String SubfolderId = folderService.folderUploadService(codigoImovel,idFolder);

		//Nome Do Arquivo Vai Aqui... 
		List<Image> listImagens = imageParser.parser(files, codigoImovel);

		for (Image image:listImagens) {
			this.filesService.uploadDrive(image, SubfolderId);
		}

		buildingImageService.addImagensToBuilding(cpnj, codigoImovel, listImagens);

		return (null);

	}


}
