package kr.ac.kopo.ctc.spring.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.repository.BoardGroupRepository;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;
import kr.ac.kopo.ctc.spring.board.service.BoardItemService;

//테스트가 Spring으로 돌아갈 수 있게 해주는 어노테이션
@SpringBootTest
class SpringBoard1ApplicationTests {
	//Autowired 로 IoC컨테이너 안에 Bean주입
	//= BoardItemRepository boardItemRepository = new BoardItemRepository();
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	@Autowired
	private BoardGroupRepository boardGroupRepository;

	//부모 자식 cascade 삭제 테스트
//	@Test
//	public void TestCascadeDelete(){
//		Optional<BoardGroup> boardGroupOpt = boardGroupRepository.findById(4);
//		BoardGroup boardGroup = boardGroupOpt.get();
//		boardGroupRepository.delete(boardGroup);
//	}
	
	//부모 자식 fetchType 변경 테스트
//	@Test
//	public void TestFetchType(){
//		Optional<BoardGroup> boardGroupOpt = boardGroupRepository.findById(1);
//		System.out.println(boardGroupOpt);
//	}
	
	//C (group)
//	@Test
//	public void TestSaveGroup(){
//		BoardGroup boardGroup = new BoardGroup();
//		boardGroup.setName("SecondGroup");
//		boardGroupRepository.save(boardGroup);
//		
//	}
//	//C (item)
//	@Test
//	public void TestSaveItem(){
//		Optional<BoardGroup> boardGroupOpt = boardGroupRepository.findById(4);
//		BoardGroup boardGroup = boardGroupOpt.get();
//		
//		BoardItem boardItem = new BoardItem("홍길동3", new Date(), 3, "타이틀3입니다.", 1, boardGroup);
//
//		boardItemRepository.save(boardItem);
//		
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
//	@Test
//	public void TestfindAllPage(){
//		PageRequest pageable = PageRequest.of(0, 10);
//		Page<BoardItem> page = boardItemRepository.findAll(pageable);		
//		
//		System.out.println(page.getContent());
//	}
//	
//	//search + page
//	@Test
//	public void TestfindAllSearchPage(){
//		PageRequest pageable = PageRequest.of(0, 10);
//		Page<BoardItem> page = boardItemRepository.findAllByTitleContaining("타이틀",pageable);
//		
//		System.out.println(page.getContent());
//	}

//	트랜잭션 테스트
	
	@Autowired
	private BoardItemService boardItemService;

	@Ignore
	@Test
	void testNoTransactional() {
		boardItemService.testNoTransactional();
	}
	
	@Test
	void testTransactional() {
		boardItemService.testTransactional();
	}
}
