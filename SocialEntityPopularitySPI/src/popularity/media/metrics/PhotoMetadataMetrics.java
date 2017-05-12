package popularity.media.metrics;



public class PhotoMetadataMetrics extends  MediaMetadataMetrics{

	private String tag; 
	private String description;
	private String resolution;
	
	
	public PhotoMetadataMetrics(String id, String url, String ceratedAt,
			String tag, String description, String resolution) {
		super(id, url, ceratedAt);
		this.tag = tag;
		this.description = description;
		this.resolution = resolution;
	}
	
	
	
	public String getTag() {
		return tag;
	}



	public void setTag(String tag) {
		this.tag = tag;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getResolution() {
		return resolution;
	}



	public void setResolution(String resolution) {
		this.resolution = resolution;
	}



	@Override
	public String toString() {
		return "PhotoMetadataMetrics [tag=" + tag + ", description="
				+ description + ", resolution=" + resolution + "]";
	}
	

}
