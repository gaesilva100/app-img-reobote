package com.reobote.img.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reobote.img.domain.Image;
import com.reobote.img.domain.ImageEntity;
import com.reobote.img.repository.ImgRepository;

@Service
public class BuildingImageService {
	
	@Autowired
	private ImgRepository imgRepository;
	
	public void addImagensToBuilding(String cnpj,String contractcode,List<Image> imagens) {
		// Estudar  15/06  --https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
		List<ImageEntity> imageEntity = imagens.stream().<ImageEntity>map( image -> image ).collect(Collectors.toList());
		imgRepository.addBuildingImages(cnpj, contractcode, imageEntity);
	}

}
