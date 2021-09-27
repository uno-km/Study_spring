package org.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.study.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public String basic() {
		log.info("basic..................");
		return "sample/sample";
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get...................");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "sample/ex01";
	}

	@GetMapping("/home")
	public String home() {
		log.info("Go home");
		return "";
	}
}
