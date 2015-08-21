package com.myrecommended.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class RecommendedImage extends PersistibleEntity {

	public RecommendedImage() {
	}
	
	public RecommendedImage(String path, boolean isPrincipal) {
		this.path = path;
		this.isPrincipal = isPrincipal;
	}
	
	@Column(name="path")
	private String path;
	
	@Column(name="isPrincipal")
	private boolean isPrincipal;

	@ManyToOne
    @JoinColumn(name="recommendedId", insertable=false, 
            updatable=false, nullable=false)
	private Recommended recommended;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isPrincipal() {
		return isPrincipal;
	}

	public void setPrincipal(boolean isPrincipal) {
		this.isPrincipal = isPrincipal;
	}

	public Recommended getRecommended() {
		return recommended;
	}

	public void setRecommended(Recommended recommended) {
		this.recommended = recommended;
	}

	public String toString() {
		return this.path;
	}
	
	public boolean equals(Object obj){
		if(obj == null || !(obj instanceof RecommendedImage)){
			return false;
		}
		
		if(obj == this){
			return true;
		}
		
		RecommendedImage img = (RecommendedImage)obj;
		return img.getId().equals(this.getId());
	}
}