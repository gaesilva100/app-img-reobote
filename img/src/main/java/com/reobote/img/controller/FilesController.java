package com.reobote.img.controller;



import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mortbay.jetty.security.HashUserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reobote.img.domain.Image;
import com.reobote.img.service.FilesService;
import com.reobote.img.service.RegisterImgBuildingFacade;

@RestController
@RequestMapping("/files") 
public class FilesController {

	@Autowired
	
	private RegisterImgBuildingFacade registerImgBuildingFacade;




	// Upload_Na Maquina.
	@PostMapping("{idimovel}")
	public ArrayList<String> upload(@PathVariable(value="idimovel")String idimovel,@RequestParam(value= "files") MultipartFile []files  ) throws IllegalStateException, IOException{
		ArrayList<String> registerImages = this.registerImgBuildingFacade.registerImages(idimovel, files);
		//registerImages.get(index);
		//System.out.println("Mime Type: " + folder.getMimeType() + " --- Name: " + folder.getName());
		
		return(registerImages);
		
	}








}
