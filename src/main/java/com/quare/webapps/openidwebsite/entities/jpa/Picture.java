package com.quare.webapps.openidwebsite.entities.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="album",schema="quareappdb")
public class Picture extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PICTURE_ID")
	private Long id;
	
	@Column(name="PATH")
	private String path;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALBUM_ID")
	private Album album;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	
}
