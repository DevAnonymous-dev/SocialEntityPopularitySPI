package popularity.media.metrics;

public class MediaPopularityMetrics {
	
	 private MediaMetadataMetrics metadata;
	 private MediaUserFeedBackMetrics userFeedBack;
	 private UserPopularityMetrics authorMetrics;
	 



	public MediaPopularityMetrics(MediaMetadataMetrics metadata,
			MediaUserFeedBackMetrics userFeedBack,
			UserPopularityMetrics authorMetrics) {
		super();
		this.metadata = metadata;
		this.userFeedBack = userFeedBack;
		this.authorMetrics = authorMetrics;
	}

	public MediaPopularityMetrics() {
		super();
		
	}



	
	public MediaMetadataMetrics getMetadata() {
		return metadata;
	}



	public void setMetadata(MediaMetadataMetrics metadata) {
		this.metadata = metadata;
	}



	public MediaUserFeedBackMetrics getUserFeedBack() {
		return userFeedBack;
	}



	public void setUserFeedBack(MediaUserFeedBackMetrics userFeedBack) {
		this.userFeedBack = userFeedBack;
	}

	


	public UserPopularityMetrics getAuthorMetrics() {
		return authorMetrics;
	}




	public void setAuthorMetrics(UserPopularityMetrics authorMetrics) {
		this.authorMetrics = authorMetrics;
	}




	@Override
	public String toString() {
		return "MediaPopularityMetrics [metadata=" + metadata
				+ ", userFeedBack=" + userFeedBack + ", authorMetrics="
				+ authorMetrics + "]";
	}
	 

}
