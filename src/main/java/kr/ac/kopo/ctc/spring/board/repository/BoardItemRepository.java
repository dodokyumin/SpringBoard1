package kr.ac.kopo.ctc.spring.board.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem>{
	
	
	//C UD는 기본적으로 하이버네이트(Impl 역할)에서 구현 되어(.save, .delete등) 있으므로 
	//추가적인 기능들을 interface에 선언해주기만 하면 된다.
	
	//R
	//한개(BoardItem 도메인의 id필드에 대한 결과값을 리턴 해준다는 것) 하이버네이트에 이미 존재
	
	//전체(이미 존재)

	//page
	
	//search
	List<BoardItem> findAllByTitleContaining(String search);
	
	//page + search
	Page<BoardItem> findAllByTitleContaining(String search, Pageable pageable);
	
}
