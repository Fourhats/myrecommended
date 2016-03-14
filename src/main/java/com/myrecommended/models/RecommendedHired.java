package com.myrecommended.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recommendedhired")
public class RecommendedHired extends PersistibleEntity {

	public RecommendedHired() {
	}
	
	public RecommendedHired(Recommended recommended, User user){
		this.recommended = recommended;
		this.user = user;
		this.hiredDate = new Date();
	}
	
	@ManyToOne
    @JoinColumn(name="recommendedId")
	private Recommended recommended;
	
	@ManyToOne
    @JoinColumn(name="userId")
	private User user;
	
    @Column(name="hiredDate")
	private Date hiredDate;
    
    @Column(name="star")
    private int star;
    
    @Column(name="priceStars")
    private int priceStars;
    
    @Column(name="timeStars")
    private int timeStars;
    
    @Column(name="recommendedFeedback")
    private String recommendedFeedback;
    
    @Column(name="userFeedback")
    private String userFeedback;

	public Recommended getRecommended() {
		return recommended;
	}

	public void setRecommended(Recommended recommended) {
		this.recommended = recommended;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	public int getPriceStars() {
		return priceStars;
	}

	public void setPriceStars(int priceStars) {
		this.priceStars = priceStars;
	}

	public int getTimeStars() {
		return timeStars;
	}

	public void setTimeStars(int timeStars) {
		this.timeStars = timeStars;
	}

	public String getRecommendedFeedback() {
		return recommendedFeedback;
	}

	public void setRecommendedFeedback(String recommendedFeedback) {
		this.recommendedFeedback = recommendedFeedback;
	}

	public String getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(String userFeedback) {
		this.userFeedback = userFeedback;
	}
}