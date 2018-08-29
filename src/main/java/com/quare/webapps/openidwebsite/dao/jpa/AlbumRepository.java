package com.quare.webapps.openidwebsite.dao.jpa;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.quare.webapps.openidwebsite.entities.jpa.Album;
import com.quare.webapps.openidwebsite.entities.jpa.User;

public interface AlbumRepository extends Repository<Album, Long> {

	public List<Album> findByOwner(User owner);
	public List<Album> findByOwnerEmail(String email);
	
}
