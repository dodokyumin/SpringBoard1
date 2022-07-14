package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@Service
public class BoardItemServiceImpl implements BoardItemService {

	@Override
	public void test() {
		System.out.println("BoardItemServiceImple.test() 메소드 호출");
	}

	@Override
	public void testAopBefore() {
		System.out.println("BoardItemServiceImple.testAopBefore() 메소드 호출");
	}

	@Override
	public void testAopAfter() {
		System.out.println("BoardItemServiceImple.testAopAfter() 메소드 호출");
	}

	@Override
	public String testAopAfterReturning() {
		System.out.println("BoardItemServiceImple.testAopAfterReturning() 메소드 호출");
		return "Success";
	}

	@Override
	public void testAopAfterThrowing() {
		System.out.println("BoardItemServiceImple.testAopAfterThrowing() 메소드 호출");
		throw new RuntimeException("runtime exception 발생");
	}

	@Override
	public void testAopAround() {
		System.out.println("BoardItemServiceImple.testAopAround() 메소드 호출");
		
	}
	
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	@Override
	public String testNoAop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testAop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testNoTransactional() {
		BoardItem boardItem = boardItemRepository.findById(1).get();
		boardItem.setTitle("transaction 실습");
		boardItemRepository.save(boardItem);
		
		throw new RuntimeException("Spring Boot No Transaction Test");
	}

	@Override
	@Transactional
	public String testTransactional() {
		BoardItem boardItem = boardItemRepository.findById(1).get();
		boardItem.setTitle("transaction 실습");
		boardItemRepository.save(boardItem);
		
		throw new RuntimeException("Spring Boot Transaction Test");
	}

}
