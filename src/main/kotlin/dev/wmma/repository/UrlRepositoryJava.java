package dev.wmma.repository;

import java.util.List;

import javax.transaction.Transactional;

import dev.wmma.model.Url;

public class UrlRepositoryJava {
	
	public static List<Url> listAllUrls(){
		 return Url.listAll();
	}
	
	@Transactional
	public static void saveUrl(Url newUrl){
		newUrl.persist();
	}
	
}
