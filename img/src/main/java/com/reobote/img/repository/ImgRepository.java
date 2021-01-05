
  package com.reobote.img.repository;
  
  import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import  org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;
import com.reobote.img.domain.ImageEntity;

  
  @Repository 
  public class ImgRepository  {
	  
		//Creat by : Gabriel Erick 
		// 15/06
		
	  
	  
	  private MongoTemplate mongotemplate;
	  public ImgRepository (MongoTemplate mongotemplate) {
		  this.mongotemplate = mongotemplate;
	  }
	  
	  //
	  public void addBuildingImages(String cnpj,String contractcode,List<ImageEntity> imagens )  {
		  Query query = new Query (Criteria.where("cnpj").is(cnpj).and("buildings").
				  elemMatch(Criteria.where("contractCode").is(contractcode)));
		  Update update =new Update().set("buildings.$.images", imagens);
		  UpdateResult updateResult = this.mongotemplate.updateFirst(query, update, "imobiliarias");
		  System.out.println(updateResult.getMatchedCount());
		  
		  // if updateResult.getMatchedcout = 0 {
	   // }
		  
		  //throw new Exception();
	  
		  
	  }
  
 
  }
 