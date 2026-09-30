package com.trial.RestApiCrud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateRequestDto {
	
	private String name;
	
	private Double price;

}
