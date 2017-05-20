package com.popularity.media.metadata;

import java.util.Date;


public class VideoMetadataMetrics extends  MediaMetadataMetrics{
	

	private String name;
	private String description;
	private String category;
	private String  tag;
	private String duration;
	
	

	public VideoMetadataMetrics(String id, String url, Date ceratedAt,
			String name, String description, String category, String tag,
			String duration) {
		super(id, url, ceratedAt);
		this.name = name;
		this.description = description;
		this.category = category;
		this.tag = tag;
		this.duration = duration;
	}
	
	
	public VideoMetadataMetrics( String url, Date ceratedAt,
			String name, String description, String category, String tag,
			String duration) {
		super( url, ceratedAt);
		this.name = name;
		this.description = description;
		this.category = category;
		this.tag = tag;
		this.duration = duration;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "VideoMetadataMetrics [name=" + name + ", description="
				+ description + ", category=" + category + ", tag=" + tag
				+ ", duration=" + duration + "]";
	}

	

}
