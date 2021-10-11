package org.study.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class SampleTxServiceTests {

	@Setter(onMethod_ = { @Autowired })
	private SampleTxService service;

	@Test
	public void testLong() {

		String str = "트랜잭션은 비즈니스 계층에서 이루어지므로, org.study.service"
				+ "계층에서 Sample1Mapper, Sample2Mapper를 사용하는 SampleTxSe"
				+ "vice인터페이스, SampleTxServiceImpl클래스를 설계하자";

		log.info(str.getBytes().length);

		service.addData(str);
	}

}
