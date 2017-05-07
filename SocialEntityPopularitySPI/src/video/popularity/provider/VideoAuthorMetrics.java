package video.popularity.provider;

public class VideoAuthorMetrics {
	private String authorId;
	private int nbIndegree;
	private int nbpost;
	private int nbOutdegree;

	public VideoAuthorMetrics(String authorId, int nbIndegree, int nbpost,
			int nbOutdegree) {
		super();
		this.authorId = authorId;
		this.nbIndegree = nbIndegree;
		this.nbpost = nbpost;
		this.nbOutdegree = nbOutdegree;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public int getNbIndegree() {
		return nbIndegree;
	}

	public void setNbIndegree(int nbIndegree) {
		this.nbIndegree = nbIndegree;
	}

	public int getNbpost() {
		return nbpost;
	}

	public void setNbpost(int nbpost) {
		this.nbpost = nbpost;
	}

	public int getNbOutdegree() {
		return nbOutdegree;
	}

	public void setNbOutdegree(int nbOutdegree) {
		this.nbOutdegree = nbOutdegree;
	}

	@Override
	public String toString() {
		return "VideoAuthorMetrics [authorId=" + authorId + ", nbIndegree="
				+ nbIndegree + ", nbpost=" + nbpost + ", nbOutdegree="
				+ nbOutdegree + "]";
	}

}
