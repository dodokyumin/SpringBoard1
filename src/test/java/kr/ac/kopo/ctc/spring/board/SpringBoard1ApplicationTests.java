package kr.ac.kopo.ctc.spring.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

//테스트가 Spring으로 돌아갈 수 있게 해주는 어노테이션
@SpringBootTest
class SpringBoard1ApplicationTests {
	//Autowired 로 IoC컨테이너 안에 Bean주입
	//= BoardItemRepository boardItemRepository = new BoardItemRepository();
	@Autowired
	private BoardItemRepository boardItemRepository;
//
//	//C
//	@Test
//	public void TestSave(){
//		
//		BoardItem boardItem = new BoardItem();
//		Date date = new Date();
//		boardItem.setCreated(date);
//		boardItem.setView(0);
//		boardItem.setAuthor("홍길동3");
//		boardItem.setNo(8);
//		boardItem.setTitle("타이틀3입니다.");
//		boardItemRepository.save(boardItem);
//		
//		assertEquals(boardItemRepository.findAll(), 4);
//	}
//	
//	//U
//	@Test
//	public void TestUpdate(){
//		
//		int updateId = 1;
//		String updateTitle = "수정된 타이틀";
//		Optional<BoardItem> BoardItemOpt = boardItemRepository.findById(updateId);
//		BoardItem boardItem = BoardItemOpt.get();
//		boardItem.setTitle(updateTitle);
//		boardItemRepository.save(boardItem);
//		
//		assertEquals(boardItemRepository.findById(1).get().getTitle(), "수정된 타이틀");
//	}
//	
//	//D
//	@Test
//	public void TestDelete(){
//		
//		int deleteId = 5;
//		Optional<BoardItem> BoardItemOpt = boardItemRepository.findById(deleteId);
//		BoardItem boardItem = BoardItemOpt.get();
//		boardItemRepository.delete(boardItem);
//		
//		assertEquals(boardItemRepository.findAll(), 3);
//	}
//	
//	//R
//	//한개
//	@Test
//	public void TestfindOneById() {
//		//DB에서 null체크를 유용하게 하기 위한 optional
//		Optional<BoardItem> boardItemOpt = boardItemRepository.findById(1);
//		BoardItem boardItem = boardItemOpt.get();
//		assertEquals(boardItem.toString(),"BoardItem [id=1, no=1, title=수정된 타이틀, author=슈퍼맨, created=2022-07-08 00:00:00.0, view=0]");
//	}
//	
//	//여러개
//	@Test
//	public void TestfindAll() {
//		List<BoardItem> boardItemAll = boardItemRepository.findAll();
//		
//		assertEquals(boardItemAll.size(),3);
//	}
//	
//	//search
//	@Test
//	public void TestfindAllByTitleContaining() {
//		List<BoardItem> boardItemSearchAll = boardItemRepository.findAllByTitleContaining("타이틀");
//		
//		assertEquals(boardItemSearchAll.size(),3);
//	}

	//page
	@Test
	public void TestfindAllPage(){
		PageRequest pageable = PageRequest.of(0, 10);
		Page<BoardItem> page = boardItemRepository.findAll(pageable);		
		
		System.out.println(page.getContent());
	}
//	
//	//search + page
//	@Test
//	public void TestfindAllSearchPage(){
//		PageRequest pageable = PageRequest.of(0, 10);
//		Page<BoardItem> page = boardItemRepository.findAllByTitleContaining("타이틀",pageable);
//		
//		System.out.println(page.getContent());
//	}


}
