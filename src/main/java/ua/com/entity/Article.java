package ua.com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String data;
	
	private LocalDate dateofPublic;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	public Article() {

	}

	public Article( String name, String data) {
		super();
	
		this.name = name;
		this.data = data;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public LocalDate getDateofPublic() {
		return dateofPublic;
	}

	public void setDateofPublic(LocalDate dateofPublic) {
		this.dateofPublic = dateofPublic;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", data=" + data + ", dateofPublic=" + dateofPublic + "]";
	}


	
}
