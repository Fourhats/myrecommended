package com.myrecommended.services.recommended.dtos;

import java.util.Date;

import com.myrecommended.services.users.dtos.BaseUserDTO;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;

public class RecommendedHiredDTO extends MyRecommendedBaseDTO {
	
	private long id;

	private RecommendedDTO recommended;
	
	private BaseUserDTO user;
	
	private Date hiredDate;
    
    private int star;
    
    private String recommendedFeedback;
    
    private String userFeedback;
    
    private boolean hasRecommendedFeedback;
    
    private boolean hasUserFeedback;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RecommendedDTO getRecommended() {
		return recommended;
	}

	public void setRecommended(RecommendedDTO recommended) {
		this.recommended = recommended;
	}
	
	public BaseUserDTO getUser() {
		return user;
	}

	public void setUser(BaseUserDTO user) {
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
		this.setHasRecommendedFeedback(this.star != 0);
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
		this.setHasUserFeedback(this.userFeedback != null);
	}

	public boolean isHasRecommendedFeedback() {
		return hasRecommendedFeedback;
	}

	public void setHasRecommendedFeedback(boolean hasRecommendedFeedback) {
		this.hasRecommendedFeedback = hasRecommendedFeedback;
	}

	public boolean isHasUserFeedback() {
		return hasUserFeedback;
	}

	public void setHasUserFeedback(boolean hasUserFeedback) {
		this.hasUserFeedback = hasUserFeedback;
	}
}