package com.reobote.img.controller;



import java.io.IOException;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.reobote.img.service.RegisterImgBuildingFacade;

@RestController
@RequestMapping("/files") 
public class FilesController {

	@Autowired
	
	private RegisterImgBuildingFacade registerImgBuildingFacade;


	@PostMapping("{contractCode}")
	public String upload(@PathVariable(value="contractCode")String contractCode,@RequestParam(value= "files") MultipartFile []files,@RequestParam(value="cpnj")String cpnj ) throws IllegalStateException, IOException{
		String registerImages = this.registerImgBuildingFacade.registerImages(cpnj,contractCode, files);
		System.out.println("o que tem aqui " + registerImages);
		return(registerImages);
		
	}








}
