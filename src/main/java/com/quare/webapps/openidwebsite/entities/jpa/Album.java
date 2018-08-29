package com.quare.webapps.openidwebsite.entities.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="album",schema="quareappdb")
public class Album extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ALBUM_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="album",cascade=CascadeType.ALL)
	private List<Picture> pictures;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OWNER_ID")
	private User owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public void addPicture(Picture picture) {
		if (pictures==null) {
			pictures=new ArrayList<Picture>();
		}
		
		pictures.add(picture);
		picture.setAlbum(this);
	}
	
	

}
