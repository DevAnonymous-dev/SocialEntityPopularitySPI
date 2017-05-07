package video.popularity.provider;

public class VideoFeedBackMetrics {
private int nbView;
private int nbRating;
private int nbLikes;
private int nbShare;
private int nbComment;


public VideoFeedBackMetrics(int nbView, int nbRating, int nbLikes, int nbShare,
		int nbComment) {
	super();
	this.nbView = nbView;
	this.nbRating = nbRating;
	this.nbLikes = nbLikes;
	this.nbShare = nbShare;
	this.nbComment = nbComment;
}



public int getNbView() {
	return nbView;
}



public void setNbView(int nbView) {
	this.nbView = nbView;
}



public int getNbRating() {
	return nbRating;
}



public void setNbRating(int nbRating) {
	this.nbRating = nbRating;
}



public int getNbLikes() {
	return nbLikes;
}



public void setNbLikes(int nbLikes) {
	this.nbLikes = nbLikes;
}



public int getNbShare() {
	return nbShare;
}



public void setNbShare(int nbShare) {
	this.nbShare = nbShare;
}



public int getNbComment() {
	return nbComment;
}



public void setNbComment(int nbComment) {
	this.nbComment = nbComment;
}



@Override
public String toString() {
	return "VideoFeedBackMetrics [nbView=" + nbView + ", nbRating=" + nbRating
			+ ", nbLikes=" + nbLikes + ", nbShare=" + nbShare + ", nbComment="
			+ nbComment + "]";
}

}
