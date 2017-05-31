package com.popularity.media.feedback;

public class VideoUserFeedBackMetrics extends MediaUserFeedBackMetrics {
	private String nbRating;
	private int nbView;
	
	public VideoUserFeedBackMetrics(int nbShare, int nbComments,
			int nbPositiveVote, int nbNegativeVote, String nbRating, int nbView) {
		super(nbShare, nbComments, nbPositiveVote, nbNegativeVote);
		this.nbRating = nbRating;
		this.nbView = nbView;
	}

	public String getNbRating() {
		return nbRating;
	}

	public void setNbRating(String nbRating) {
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
