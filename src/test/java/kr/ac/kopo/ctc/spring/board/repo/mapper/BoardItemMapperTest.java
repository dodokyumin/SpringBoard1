package kr.ac.kopo.ctc.spring.board.repo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

//@SpringBootConfiguration
@SpringBootTest
public class BoardItemMapperTest {

	private static final Logger Logger = LoggerFactory.getLogger(BoardItemMapperTest.class);
	
	@Autowired
	BoardItemMapper boardItemMapper;
	
	//C
	@Test
	public void insertTest() {
		BoardItem boardItem = new BoardItem();
		boardItem.setId(2);
		boardItem.setAuthor("홍길동2");
		boardItem.setCreated(new Date());
		boardItem.setNo(12);
		boardItem.setTitle("안녕하세요 홍길동 입니다.");
		boardItem.setView(0);
		
		int result = boardItemMapper.insert(boardItem);
		
		assertEquals(result, 1);
	}

	//R
	//SelectOne
	@Test
	public void selectTest() {
		int selectOneId = 1;
		int selectedOneNo = 1;
		Map<String, Object> condition = new HashMap<>();
		condition.put("id", selectOneId);
		BoardItem boardItem = boardItemMapper.selectOne(condition);
		
		assertEquals(boardItem.getNo(), selectedOneNo);
	}
	
	//SelectAll
	@Test
	public void findAllTest() {
		List<BoardItem> boardItems= boardItemMapper.findAll();
		for (BoardItem item : boardItems) {
			Logger.info(item.getTitle());
		}
	}

	//Search
	@Test
	public void findByConditionTest() {
		BoardItemCondition boardItem = new BoardItemCondition();
		boardItem.setTitle("안녕하세요");
		
		List<BoardItem> boardItems = boardItemMapper.findAllByCondition(boardItem);
		
		for (BoardItem item : boardItems) {
			Logger.info(item.getTitle());
		}
	}
	
	//Page
	@Test
	public void findByPageTest() {
		RowBounds rowBounds = new RowBounds(10,12);
		
		List<BoardItem> boardItems= boardItemMapper.findAllByPage(rowBounds);
		
		for (BoardItem item : boardItems) {
			Logger.info(item.getTitle());
		}
	}	
	
	//Search + page
	@Test
	public void findAllByPageConditionTest() {
		BoardItemCondition boardItemCondition = new BoardItemCondition();
		boardItemCondition.setTitle("안녕하세요");
		
		RowBounds rowBounds = new RowBounds(0,5);

		List<BoardItem> boardItems= boardItemMapper.findAllByPageCondition(boardItemCondition, rowBounds);
		
		for (BoardItem item : boardItems) {
			Logger.info(item.getTitle());
		}
	}
	
	
	//U
	@Test
	public void updateTest() {
		String newTitle = "새로운 타이틀입니다.-mybatis";
		Map<String, Object> condition = new HashMap<>();
		condition.put("id", 8);
		
		BoardItem boardItem = boardItemMapper.selectOne(condition);
		
		boardItem.setTitle(newTitle);
		
		boardItemMapper.update(boardItem);
		
		boardItem = boardItemMapper.selectOne(condition);
		assertEquals(boardItem.getTitle(), newTitle);
	}
	
	
	//D
	@Test
	public void deleteTest() {
		int result = boardItemMapper.delete(17);		
		assertEquals(result,1);
	}

}
