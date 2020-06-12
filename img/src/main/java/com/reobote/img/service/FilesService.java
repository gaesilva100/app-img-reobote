package com.reobote.img.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.services.drive.model.File;
import com.reobote.img.domain.Image;
import com.reobote.img.repository.CreateGoogleFile;
import com.reobote.img.repository.FindFilesByName;


/**
 * @author Gabriel Erick Silva
 *
 */
@Service
public class FilesService {


	private FindFilesByName findFilesByname;
	private CreateGoogleFile createGoogleFile;


	public FilesService(FindFilesByName findFilesByname,CreateGoogleFile createGoogleFile) {
		this.findFilesByname = findFilesByname;
		this.createGoogleFile = createGoogleFile;

	}


	// Buscar - Não  corrigido 04_06_2020
	public  void buscar() throws IOException { 

		List<File> rootGoogleFolders = findFilesByname.getGoogleFilesByName("uteis");

		for (File folder : rootGoogleFolders) {
			System.out.println("Mime Type: " + folder.getMimeType() + " --- Name: " + folder.getName());
		}
		System.out.println("Done!");
	}

	// Buscar - Não  FindOne 04_06_2020
	public File findOne(String name) throws IOException {

		List<File> rootGoogleFolders = findFilesByname.getGoogleFilesByName(name);

		for (File folder : rootGoogleFolders) {
			System.out.println("Mime Type: " + folder.getMimeType() + " --- Name: " + folder.getName());
		}
		System.out.println("Done!");

		return null;
	}

	// tratamento do upload do arquivo.
	public  String uploadDrive(Image image,String folderParentId ) throws IllegalStateException, IOException {
		
		
		
		
		File file = createGoogleFile.createGoogleFileByte(folderParentId, "image/jpeg", image.getName(), image.getContent());
		image.setUrl(file.getWebContentLink());
		System.out.println(file.getWebContentLink());

		return (null);
	}

	// tratamento do 
	public String validaExtensao(MultipartFile file)throws IllegalStateException, IOException {
		
		byte[] bytes = file.getBytes();


		System.out.println("aqui 3 -" + System.getProperty("user.dir"));

		Pattern pattern = Pattern.compile("\\.(\\w+)$");
		String extensaoarquivo = file.getOriginalFilename().replaceFirst("\\w+$", "$0");


		return (extensaoarquivo);
	}

	
	
	
}
