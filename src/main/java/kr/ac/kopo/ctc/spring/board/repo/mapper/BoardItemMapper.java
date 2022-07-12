package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Mapper
@Repository
public interface BoardItemMapper {
	//C
	int insert(BoardItem boardItem);
	
	//R
	//readOne
	BoardItem selectOne(Map<String, Object> condition);
	//readAll
	List<BoardItem> findAll();
	//read Search
	List<BoardItem> findAllByCondition(BoardItemCondition condition);
	//read Page
	List<BoardItem> findAllByPage(RowBounds rowBounds);
	//read Search + Page
	List<BoardItem> findAllByPageCondition(BoardItemCondition condition, RowBounds rowBounds);
	
	//U
	int update(BoardItem boardItem);
	
	//D
	int delete(int id);
}
