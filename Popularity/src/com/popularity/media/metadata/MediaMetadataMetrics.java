package com.popularity.media.metadata;

import java.util.Date;


public class MediaMetadataMetrics {
	
	private String id;
	private String url;
	private Date createdAt;
	



	public MediaMetadataMetrics(String id, String url, Date createdAt) {
		super();
		this.id = id;
		this.url = url;
		this.createdAt = createdAt;
	}

	public MediaMetadataMetrics(String url, Date createdAt) {
		super();
	
		this.url = url;
		this.createdAt = createdAt;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "MediaMetadataMetrics [id=" + id + ", url=" + url
				+ ", createdAt=" + createdAt + "]";
	}





}
