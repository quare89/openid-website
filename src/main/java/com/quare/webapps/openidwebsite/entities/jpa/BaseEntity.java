package com.quare.webapps.openidwebsite.entities.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity {

	@Column(name="CREATE_DATE")
	protected Date createDate;
	
	@Column(name="UPDATE_DATE")
	protected Date updateDate;
	
	@Column(name="END_DATE")
	protected Date endDate;
	
	@PreUpdate
	public void doOnUpdate() {
		this.setUpdateDate(new Date());
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
