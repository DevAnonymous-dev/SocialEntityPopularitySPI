package popularity.media.metrics;

public class UserProfileMetadata {
	private String id;
	private String url;
	private String name;
	private String gender;
	private String description;
	private String category;
	private String createdAt;
	
	
	public UserProfileMetadata(String id, String url, String name,
			String gender, String description, String category, String createdAt) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.gender = gender;
		this.description = description;
		this.category = category;
		this.createdAt = createdAt;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "UserProfileMetadata [id=" + id + ", url=" + url + ", name="
				+ name + ", gender=" + gender + ", description=" + description
				+ ", category=" + category + ", createdAt=" + createdAt + "]";
	}
	
	

}
