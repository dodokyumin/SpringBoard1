package kr.ac.kopo.ctc.spring.board.service;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardItemServiceImplTest {

	@Autowired
	private BoardItemServiceImpl boardItemService;

	@Test
	void test() {
		boardItemService.test();
	}
//	
//	@Test
//	void testAopBefore() {
//		boardItemService.testAopBefore();
//	}
//	@Test
//	void testAopAfter() {
//		boardItemService.testAopAfter();
//	}
//	@Test
//	void testAopAfterReturning() {
//		boardItemService.testAopAfterReturning();
//	}
//	@Test
//	void testAopAfterThrowing() {
//		boardItemService.testAopAfterThrowing();
//	}
//	@Test
//	void testAopAround() {
//		boardItemService.testAopAround();
//	}
//	


}
