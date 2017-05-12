package popularity.media.metrics;

public class VideoUserFeedBackMetrics extends MediaUserFeedBackMetrics {
	private int nbRating;
	private int nbView;
	
	public VideoUserFeedBackMetrics(int nbShare, int nbComments,
			int nbPositiveVote, int nbNegativeVote, int nbRating, int nbView) {
		super(nbShare, nbComments, nbPositiveVote, nbNegativeVote);
		this.nbRating = nbRating;
		this.nbView = nbView;
	}

	public int getNbRating() {
		return nbRating;
	}

	public void setNbRating(int nbRating) {
		this.nbRating = nbRating;
	}

	public int getNbView() {
		return nbView;
	}

	public void setNbView(int nbView) {
		this.nbView = nbView;
	}

	@Override
	public String toString() {
		return "VideoUserFeedBackMetrics [nbRating=" + nbRating + ", nbView="
				+ nbView + "]";
	}
	
	

}
