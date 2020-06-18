package com.reobote.img.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.reobote.img.domain.Image;

import com.reobote.img.service.FolderService;


@RestController
@RequestMapping("/folder") 
public class FolderController {

	@Autowired
	private FolderService folderService;

	
	
	/*
	 * @GetMapping("{cnpj}")// Busca imobiliaria pelo CNPJ public
	 * ResponseEntity<Image> findById(@PathVariable (value="cnpj") String cnpj) {
	 * ImgRepository dto = this.imgRepository.findByCnpj(cnpj); return
	 * ResponseEntity.ok(dto); }
	 */

	// Upload_Na Maquina.
	@PostMapping("{name}")
	public String folder(@PathVariable(value="name") String name) throws IOException {
		// 
		folderService.folder(name);

		return("Essa Bagaça ta Funcionando !!!");

	}


}
