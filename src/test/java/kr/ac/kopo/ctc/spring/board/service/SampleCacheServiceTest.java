package kr.ac.kopo.ctc.spring.board.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleCacheServiceTest {

	private static final Logger Logger = LoggerFactory.getLogger(SampleCacheServiceTest.class);
	
	@Autowired
	private SampleCacheService sampleCacheService;
	
	private long startTime;
	private long endTime;

	@Before
	public void onBefore() {
		startTime = System.currentTimeMillis();
		
	}
	@After
	public void onAfter() {
		endTime = System.currentTimeMillis();
		Logger.info("소요시간: {}ms", endTime - startTime);
		
	}

	@Test
	public void testNoCache() {
		sampleCacheService.testNoCache(1L);
	}

	@Test
	public void testCache1() {
		sampleCacheService.testCache(1L);
	}
	@Test
	public void testCache2() {
		sampleCacheService.testCache(1L);
	}
	@Test
	public void testCache3() {
		sampleCacheService.testCache(2L);
	}
	@Test
	public void testCache4() {
		sampleCacheService.testCache(1L);
	}
	@Test
	public void testCache5() {
		sampleCacheService.testCacheClear(1L);
		sampleCacheService.testCache(1L);
	}
}
