package org.study.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DatatSourceTests {

	@Setter(onMethod_ = { @Autowired })
	private DataSource ds;
	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSeesionFactory;

	@Test
	public void testConnection() {
		try (Connection con = ds.getConnection()) {
			log.info("qwe");
			log.info(con);
			log.info("connected succes");
		} catch (Exception e) {
			log.info("qwe");
			fail(e.getMessage());
		}
	}

//	@Test
//	public void testMyBatis() {
//
//		try (SqlSession session = sqlSeesionFactory.openSession(); Connection con = session.getConnection();) {
//			log.info("qwe");
//			log.info(session);
//			log.info(con);
//			log.info("success!!");
//		} catch (Exception e) {
//			log.info("qwe");
//			fail(e.getMessage());
//		}
//
//	}
}
