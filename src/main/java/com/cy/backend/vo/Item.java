package com.cy.backend.vo;

public class Item {

	private String itemid;
	private String description;
	private String url;
	private String imageurl;
	
	
	
	
	public Item(){
		
	}
	
	
	public Item(String itemid, String description, String url, String imageurl) {
		super();
		this.itemid = itemid;
		this.description = description;
		this.url = url;
		this.imageurl = imageurl;
	}
	
	
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	
}
