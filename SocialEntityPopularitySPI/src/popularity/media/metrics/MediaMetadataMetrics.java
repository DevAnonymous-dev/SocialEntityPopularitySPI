package popularity.media.metrics;


public class MediaMetadataMetrics {
	
	private String id;
	private String url;
	private String ceratedAt;
	
	public MediaMetadataMetrics(String id, String url, String ceratedAt) {
		super();
		this.id = id;
		this.url = url;
		this.ceratedAt = ceratedAt;
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




	public String getCeratedAt() {
		return ceratedAt;
	}




	public void setCeratedAt(String ceratedAt) {
		this.ceratedAt = ceratedAt;
	}




	@Override
	public String toString() {
		return "MediaMetadataMetrics [id=" + id + ", url=" + url
				+ ", ceratedAt=" + ceratedAt + "]";
	}
	
	
	

}
