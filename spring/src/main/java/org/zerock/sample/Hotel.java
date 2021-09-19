package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//필드 주입/ 세터 주입/ 생성자 주입
@Component
@ToString
@RequiredArgsConstructor
public class Hotel {
	@NonNull
	private Chef chef;
}
