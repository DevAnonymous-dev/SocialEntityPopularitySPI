package text.popularity.provider;

public class TextFeedBackMetrics {
	private int nbView;
	private int nbLike;
	private int nbShare;
	
	public TextFeedBackMetrics(int nbView, int nbLike, int nbShare){
		this.nbView=nbView;
		this.nbLike=nbLike;
		this.nbShare=nbShare;
	}
	
	public int getNbView() {
		return nbView;
	}
	public void setNbView(int nbView) {
		this.nbView = nbView;
	}
	public int getNbLike() {
		return nbLike;
	}
	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}
	public int getNbShare() {
		return nbShare;
	}
	public void setNbShare(int nbShare) {
		this.nbShare = nbShare;
	}
	
	

}
