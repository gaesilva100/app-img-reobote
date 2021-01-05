package com.reobote.img.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reobote.img.service.FolderService;


@RestController
@RequestMapping("/folder") 
public class FolderController {

	@Autowired
	private FolderService folderService;

	
	@PostMapping("{name}")
	public String createFolderGoogleDrive(@PathVariable(value="name") String name) throws IOException {
		String idFolder = folderService.folderCreateforNameService(name);
		return  ("O Id da Pasta é" + idFolder);
	}



	


}
