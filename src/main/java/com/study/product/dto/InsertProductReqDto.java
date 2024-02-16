package com.study.product.dto;

import com.study.product.vo.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsertProductReqDto {
	private String name;
	private int price;
	private String size;
	
	public Product toVo() {
		return Product.builder()
				.name(name)
				.price(price)
				.size(size)
				.build();
	}
}
