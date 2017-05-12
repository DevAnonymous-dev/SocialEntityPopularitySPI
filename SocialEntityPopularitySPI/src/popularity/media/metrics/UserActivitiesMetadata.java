package popularity.media.metrics;

public class UserActivitiesMetadata {
	 
	private int nbPosts;

	
	
	public UserActivitiesMetadata(int nbPosts) {
		super();
		this.nbPosts = nbPosts;
	}



	@Override
	public String toString() {
		return "UserActivitiesMetadata [nbPosts=" + nbPosts + "]";
	}
	
	

}
