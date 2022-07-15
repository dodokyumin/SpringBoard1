package kr.ac.kopo.ctc.spring.board.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class BoardGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@JsonBackReference
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="boardGroup")
	//@JsonManagedReference
	private List<BoardItem> boardItems;
	
	public List<BoardItem> getBoardItems() {
		if( boardItems == null) {
			boardItems = new ArrayList<BoardItem>();
		}
		return boardItems;
	}
	
	public void addBoardItem(BoardItem boardItem) {
		List<BoardItem> boardItems = getBoardItems();
		boardItems.add(boardItem);
	}

	public void setBoardItems(List<BoardItem> boardItems) {
		this.boardItems = boardItems;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
