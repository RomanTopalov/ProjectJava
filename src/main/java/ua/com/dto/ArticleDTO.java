package ua.com.dto;

public class ArticleDTO {

	private int id;
	private String name;
	
	public ArticleDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public ArticleDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
