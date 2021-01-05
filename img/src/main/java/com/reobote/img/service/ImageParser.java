package com.reobote.img.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.reobote.img.domain.Image;

@Service
public class ImageParser {
	
	@Autowired
	private NamingFileService namingFileService;
	@Autowired
	private ExtensionFileService extensionFileService;
	
	public List<Image> parser(MultipartFile [] files,String codigoImovel) throws IOException{
		
		ArrayList<Image> imagens = new ArrayList<Image>();
		
		for(MultipartFile file :files) {
			String nomearquivo = namingFileService.naming(file, codigoImovel);
			String extension = extensionFileService.getExtension(file);
			
			
			//urso.png 
			Image image = new Image();
			image.setExtension(extension); //set
			image.setName(nomearquivo +"." + extension);
			image.setContent(file.getBytes());
			imagens.add(image);
		}
		return imagens;
	}

}
