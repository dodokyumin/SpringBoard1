package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.stereotype.Service;

@Service
public class BoardItemService implements BoardItemServiceImpl {

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

}
