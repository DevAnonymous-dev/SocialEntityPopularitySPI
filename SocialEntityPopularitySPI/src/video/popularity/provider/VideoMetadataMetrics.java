package video.popularity.provider;

public class VideoMetadataMetrics {
	private String name;
	private String description;
	private String category;
	private String dateUplaod;
	
	
	
	public VideoMetadataMetrics(String name, String description,
			String category, String dateUplaod) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.dateUplaod = dateUplaod;
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
	public String getDateUplaod() {
		return dateUplaod;
	}
	public void setDateUplaod(String dateUplaod) {
		this.dateUplaod = dateUplaod;
	}
	@Override
	public String toString() {
		return "VideoMetadataMetrics [name=" + name + ", description="
				+ description + ", category=" + category + ", dateUplaod="
				+ dateUplaod + "]";
	}
	
	

}
