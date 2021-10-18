package org.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class testController {

	@GetMapping("/sample/uno")
	public void doUno() {
		log.info("Test: Controller : uno only");
	}

}
