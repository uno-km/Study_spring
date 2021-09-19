package org.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data
@Component
public class Restaurant {

	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
