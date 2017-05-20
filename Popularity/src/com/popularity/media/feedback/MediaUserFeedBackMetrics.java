package com.popularity.media.feedback;

public class MediaUserFeedBackMetrics {
	private int nbShare;
	private int nbComments;
	//defines number of likes, favorites, diggs, plusoners, etc.
	private int nbPositiveVote;
	//defines number of dislikes
	private int nbNegativeVote;
	
	
	public MediaUserFeedBackMetrics(int nbShare, int nbComments,
			int nbPositiveVote, int nbNegativeVote) {
		super();
		this.nbShare = nbShare;
		this.nbComments = nbComments;
		this.nbPositiveVote = nbPositiveVote;
		this.nbNegativeVote = nbNegativeVote;
	}
	


	public MediaUserFeedBackMetrics() {
		// TODO Auto-generated constructor stub
	}



	public int getNbShare() {
		return nbShare;
	}



	public void setNbShare(int nbShare) {
		this.nbShare = nbShare;
	}



	public int getNbComments() {
		return nbComments;
	}



	public void setNbComments(int nbComments) {
		this.nbComments = nbComments;
	}



	public int getNbPositiveVote() {
		return nbPositiveVote;
	}



	public void setNbPositiveVote(int nbPositiveVote) {
		this.nbPositiveVote = nbPositiveVote;
	}



	public int getNbNegativeVote() {
		return nbNegativeVote;
	}



	public void setNbNegativeVote(int nbNegativeVote) {
		this.nbNegativeVote = nbNegativeVote;
	}



	@Override
	public String toString() {
		return "MediaUserFeedBackMetrics [nbShare=" + nbShare + ", nbComments="
				+ nbComments + ", nbPositiveVote=" + nbPositiveVote
				+ ", nbNegativeVote=" + nbNegativeVote + "]";
	}
	
	
	

}
