package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.io.Serializable;
import java.util.Date;

public class BoardItemCondition implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String author;
	private Date created;
	private int no;
	private String title;
	private int view;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	

}
