package com.reobote.img.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

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
	
		
	

	// Upload_Na Maquina.
	@PostMapping("{name}")
	public String folder(@PathVariable(value="name") String name) throws IOException {
		// 
		folderService.folder(name);

		return("Essa Bagaça ta Funcionando !!!");

	}


}
