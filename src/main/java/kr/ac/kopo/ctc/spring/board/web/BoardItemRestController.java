package kr.ac.kopo.ctc.spring.board.web;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardGroupRepository;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@RestController
@RequestMapping(value = "/rest")
public class BoardItemRestController {
	//원래는 controller에서 DB에 바로 접근하는 것이 아니라 service통해 가지만, 실습이니 바로 DB연결 해줬음.
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	@Autowired
	private BoardGroupRepository boardGroupRepository;

	
//	// response의 값을 조작하고 싶을 때엔(response의 값 조작을 통해 404에러로 빠지는걸 다르게 출력 가능) ResponseEntity<> 타입으로 반환하여준다. 
//	//ResponseEntity.notFound() 등등 이러한 메소드로 조작.
//	@RequestMapping(value = "/boardItem1")
//	public ResponseEntity<BoardItem> boardItem1() {
//		BoardGroup boardGroup = new BoardGroup(); 
//		BoardItem boardItem = new BoardItem("홍길동3", new Date(), 3, "restController실습1",0, boardGroup);
//		
//		return ResponseEntity.ok(boardItem);
//	}
//	
//	@RequestMapping(value = "/boardItems1")
//	public ResponseEntity<List<BoardItem>> boardItems1() {
//		BoardGroup boardGroup = new BoardGroup(); 
//		BoardItem boardItem1 = new BoardItem("홍길동4", new Date(), 4, "restController실습2",0, boardGroup);
//		BoardItem boardItem2 = new BoardItem("홍길동5", new Date(), 5, "restController실습3",0, boardGroup);
//		
//		List<BoardItem> boardItems = new ArrayList<>();
//		boardItems.add(boardItem1);
//		boardItems.add(boardItem2);
//
//		return ResponseEntity.ok(boardItems);
//	}
	
	//response값 조작 필요없이 간단히 리턴타입 그대로 받고싶을 때.
	@RequestMapping(value = "/boardItem2")
	public BoardItem boardItem2() {
		
		 BoardItem boardItem = boardItemRepository.findById(1).get();
//		BoardGroup boardGroup = new BoardGroup(); 
//		BoardItem boardItem = new BoardItem("홍길동6", new Date(), 6, "restController실습4",0, boardGroup);
		
		return boardItem;
	}
	
	
	@RequestMapping(value = "/boardItems2")
	public List<BoardItem> boardItems2() {
//		
		//일반적으로 부모를 통해 자식들을 접근하지는 않는다. 쿼리문 효용성을 위해 자식들의 where groupid=? 로 자식이 부모를 바라보게 호출한다. 
		//List<BoardItem> boardItems =  boardGroupRepository.findById(1).get().getBoardItems();
		List<BoardItem> boardItems =  boardItemRepository.findAllByBoardGroupId(1);
		
		return boardItems;
	}
}
