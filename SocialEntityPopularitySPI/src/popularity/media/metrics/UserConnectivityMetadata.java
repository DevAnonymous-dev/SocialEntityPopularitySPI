package popularity.media.metrics;

public class UserConnectivityMetadata {
	//define number of friends, fans, subscriber, followers, ect
	private int indegree;
	//define number of following , subscription, etc
	private int outdegree;
	
	
	public UserConnectivityMetadata(int indegree, int outdegree) {
		super();
		this.indegree = indegree;
		this.outdegree = outdegree;
	}
	
	public int getIndegree() {
		return indegree;
	}
	public void setIndegree(int indegree) {
		this.indegree = indegree;
	}
	public int getOutdegree() {
		return outdegree;
	}
	public void setOutdegree(int outdegree) {
		this.outdegree = outdegree;
	}

	@Override
	public String toString() {
		return "UserConnectivityMetadata [indegree=" + indegree
				+ ", outdegree=" + outdegree + "]";
	}
	

	

}
