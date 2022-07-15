package kr.ac.kopo.ctc.spring.board.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardGroupRepositoryTest {

	@Autowired
	private BoardGroupRepository boardGroupRepository;
	
	@Test
	public void oneToMany_TwoWay() {
		BoardGroup boardGroup1 = new BoardGroup();
		BoardItem boardItem1 = new BoardItem();
		List<BoardItem> boardItemList1 = new ArrayList<BoardItem>();
		
		boardItem1.setId(1);
		boardItem1.setAuthor("홍길동");
		boardItem1.setCreated(new Date());
		boardItem1.setNo(1);
		boardItem1.setTitle("맹구입니다.");
		boardItem1.setView(1);
		
		boardItemList1.add(boardItem1);
				
		boardGroup1.setId(1);
		boardGroup1.setName("프리미어리그");
		boardGroup1.setBoardItems(boardItemList1);
		
//		BoardGroup boardGroup2 = new BoardGroup();
//		boardGroup2.setId(2);
//		boardGroup2.setName("라리가");
//		
//		BoardGroup boardGroup3 = new BoardGroup();
//		boardGroup3.setId(1);
//		boardGroup3.setName("세리에");

		boardGroupRepository.save(boardGroup1);
//		boardGroupRepository.save(boardGroup2);
//		boardGroupRepository.save(boardGroup3);
		
		List<BoardGroup> boardGroupList = boardGroupRepository.findAll();
		
		for(BoardGroup bg : boardGroupList) {
			System.out.println(bg.toString());
		}
		
		//boardGroupRepository.deleteAll();
	}
	
	
}
