package kr.ac.kopo.ctc.spring.board.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BoardItem {
	
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private int no;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private Date created;
	
	@Column
	private int view;
	
//	public BoardItem(int id, String author, Date date, int no, String title, int view) {
//		setId(id);
//		setAuthor(author);
//		setCreated(date);
//		setNo(no);
//		setTitle(title);
//		setView(view);
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, created, id, no, title, view);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardItem other = (BoardItem) obj;
		return Objects.equals(author, other.author) && Objects.equals(created, other.created) && id == other.id
				&& no == other.no && Objects.equals(title, other.title) && view == other.view;
	}
	
	@Override
	public String toString() {
		return "BoardItem [id=" + id + ", no=" + no + ", title=" + title + ", author=" + author + ", created=" + created
				+ ", view=" + view + "]";
	}
	
	
}
