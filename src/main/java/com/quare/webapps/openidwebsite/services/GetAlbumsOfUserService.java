package com.quare.webapps.openidwebsite.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quare.webapps.openidwebsite.dao.jpa.AlbumRepository;
import com.quare.webapps.openidwebsite.entities.jpa.Album;

@Service
public class GetAlbumsOfUserService {
	
	private static Logger log = Logger.getLogger(GetAlbumsOfUserService.class.getName());
	
	@Autowired
	AlbumRepository albumRepository;
	
	public List<Album> getAlbumOfUser(String email){
		
		List<Album> albums = albumRepository.findByOwnerEmail(email);
		if (albums == null) {
			log.info("No album for user with email "+email);
			return new ArrayList<Album>();
		} else {
			for (Album a : albums) {
				log.info("Album: " + a);
				
			}
		}
		
		return albums;
	}
	
	

}
