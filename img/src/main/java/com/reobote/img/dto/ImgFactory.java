package com.reobote.img.dto;

import java.util.ArrayList;

import com.reobote.img.domain.Image;


public class ImgFactory {
	
	//Cadastro usando o padrão DTO 
	public Image create (ImgDto dto){
		//create recebe um imgDTO > e retorna um img. 
		Image image = new Image(); 
		image.setContractCode(dto.getContractCode());
		image.setUrl(dto.getUrl());
		return image;

	}
	
	/*
	 * //Busca utilizando o padrão DTO public ImovelDto parse (Imovel imovel) {
	 * ImovelDto dto = new ImovelDto();
	 * dto.setContractCode(imovel.getContractCode());
	 * dto.setAddress(imovel.getAddress()); return dto; }
	 */


}
