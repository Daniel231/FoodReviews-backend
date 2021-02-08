package com.example.FoodReviews.models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "reviews")
public class ReviewModelLite {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "PRODUCTID")
    private String productId;

    @Column(name = "PROFILENAME")
    private String profileName;

    @Column(name = "SCORE")
    private String score;

    @Column(name = "SUMMARY")
    private String summary;

	public String getId() {
		return id;
    }
    
	public String getProductId() {
		return productId;
    }

    public String getProfileName() {
        return profileName;
    }

	public String getScore() {
		return score;
    }

    public String getSummary() {
        return summary;
    }

    public void setId(String id) {
		this.id = id;
    }
    
	public void setProductId(String productId) {
		this.productId = productId;
    }
    
	public void setProfileName(String profileName) {
		this.profileName = profileName;
    }
    
	public void setScore(String score) {
		this.score = score;
    }
    
	public void setSummary(String summary) {
		this.summary = summary;
    }
}
