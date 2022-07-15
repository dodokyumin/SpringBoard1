package kr.ac.kopo.ctc.spring.board.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@RestController
@RequestMapping(value = "/rest")
public class BoardItemRestController {

	@RequestMapping(value = "/boardItem1")
	public ResponseEntity<BoardItem> boardItem1() {
		BoardGroup boardGroup = new BoardGroup(); 
		BoardItem boardItem = new BoardItem("홍길동3", new Date(), 3, "restController실습1",0, boardGroup);
		
		return ResponseEntity.ok(boardItem);
	}
	
	@RequestMapping(value = "/boardItems1")
	public ResponseEntity<List<BoardItem>> boardItems1() {
		BoardGroup boardGroup = new BoardGroup(); 
		BoardItem boardItem1 = new BoardItem("홍길동4", new Date(), 4, "restController실습2",0, boardGroup);
		BoardItem boardItem2 = new BoardItem("홍길동5", new Date(), 5, "restController실습3",0, boardGroup);
		
		List<BoardItem> boardItems = new ArrayList<>();
		boardItems.add(boardItem1);
		boardItems.add(boardItem2);

		return ResponseEntity.ok(boardItems);
	}
	
	@RequestMapping(value = "/boardItem2")
	public BoardItem boardItem2() {
		BoardGroup boardGroup = new BoardGroup(); 
		BoardItem boardItem = new BoardItem("홍길동6", new Date(), 6, "restController실습4",0, boardGroup);
		
		return boardItem;
	}
	
	@RequestMapping(value = "/boardItems2")
	public List<BoardItem> boardItems2() {
		BoardGroup boardGroup = new BoardGroup(); 
		BoardItem boardItem1 = new BoardItem("홍길동7", new Date(), 7, "restController실습5",0, boardGroup);
		BoardItem boardItem2 = new BoardItem("홍길동8", new Date(), 8, "restController실습6",0, boardGroup);
		
		List<BoardItem> boardItems = new ArrayList<>();
		boardItems.add(boardItem1);
		boardItems.add(boardItem2);
		
		return boardItems;
	}
}
