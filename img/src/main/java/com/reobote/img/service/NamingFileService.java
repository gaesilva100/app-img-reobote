package com.reobote.img.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NamingFileService {
	
	public String naming(MultipartFile multiparte,String codigoImovel ) {
		
		String  nomearquivo = codigoImovel+"_"+UUID.randomUUID();
		return (nomearquivo);
	}

}
