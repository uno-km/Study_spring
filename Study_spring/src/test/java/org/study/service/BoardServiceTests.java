package org.study.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.study.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext wac;
	private BoardService s;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		log.info("wac : " + wac);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}

	@Test
	public void testRegi() throws Exception {
		log.info(mockMvc
				.perform(MockMvcRequestBuilders.post("/board/register").param("title", "test 테스트")
						.param("content", "content 테스트").param("writer", "writer 테스트"))
				.andReturn().getModelAndView().getModelMap());
	}

	@Test
	public void modify() throws Exception {
		String resultPage = mockMvc
				.perform(
						MockMvcRequestBuilders.post("/board/modify").param("bno", "42").param("title", "modified title")
								.param("content", "modified content").param("writer", "modified writer 테스트"))
				.andReturn().getModelAndView().getViewName();

		log.info(resultPage);
	}

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
		s.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testGet() {
		log.info(s.get(4L));
	}
}
