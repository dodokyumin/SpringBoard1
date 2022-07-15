package kr.ac.kopo.ctc.spring.board.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BoardItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	//@JsonManagedReference 참조 통과 어노테이션
	@ManyToOne(optional=false)
	@JsonBackReference//순환참조를 막기위한 어노테이션
	@JoinColumn(name="board_group_id")
	private BoardGroup boardGroup;
	
	public BoardItem(String author, Date date, int no, String title, int view, BoardGroup boardGroup ) {
		this.author = author;
		this.created = date;
		this.no = no;
		this.title = title;
		this.view = view;
		this.boardGroup = boardGroup;
		
	}
	
	public BoardItem() {
		// TODO Auto-generated constructor stub
	}

	public BoardGroup getBoardgroup() {
		return boardGroup;
	}
	public void setBoardgroup(BoardGroup boardGroup) {
		this.boardGroup = boardGroup;
	}
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
