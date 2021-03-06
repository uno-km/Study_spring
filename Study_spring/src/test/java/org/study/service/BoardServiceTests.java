package org.study.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.study.domain.BoardVO;
import org.study.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = { @Autowired })
	private BoardService s;

	@Test
	public void testPrint() {
		log.info(s);
		assertNotNull(s);
	}

	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("the new title");
		board.setContent("hi");
		board.setWriter("Kim_uno");

		s.register(board);
		log.info("Board number : " + board.getBno());

	}

	@Test
	public void testGetList() {
//		s.getList().forEach(board -> log.info(board));
		s.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}

	@Test
	public void testDelete() {
		log.info("remove result : " + s.remove(2L));
	}

	@Test
	public void testUpdate() {
		BoardVO b = s.get(2L);
		if (b == null) {
			return;
		}
		b.setTitle("Modified Title");
		log.info("Update result : " + s.modify(b));
	}

	@Test
	public void testGet() {
		log.info(s.get(4L));
	}
}
