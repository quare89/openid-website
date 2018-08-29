package com.quare.webapps.openidwebsite.dao.jpa;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.quare.webapps.openidwebsite.entities.jpa.Album;
import com.quare.webapps.openidwebsite.entities.jpa.Picture;
import com.quare.webapps.openidwebsite.entities.jpa.User;

public interface PictureRepository extends Repository<Picture, Long> {

	public List<Picture> findByAlbum(Album album);
	public List<Picture> findByAlbumOwner(User owner);
	
	
	
}
