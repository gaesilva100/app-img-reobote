package com.reobote.img.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExtensionFileService {
	
	public String getExtension(MultipartFile file) {
		String filename = file.getOriginalFilename();
		String[] split = filename.split("\\.");
		
		return split[split.length -1];
	}

}
