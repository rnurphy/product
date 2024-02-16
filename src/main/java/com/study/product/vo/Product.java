package com.study.product.vo;

import com.study.product.dto.InsertProductRespDto;
import com.study.product.dto.SearchProductRespDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
	private int productId;
	private String name;
	private int price;
	private String size;
	
	public InsertProductRespDto toInsertDto(int successCount) {
		return InsertProductRespDto.builder()
				.successCount(successCount)
				.productId(productId)
				.name(name)
				.price(price)
				.size(size)
				.build();
	}
	
	public SearchProductRespDto toSearchDto() {
		return SearchProductRespDto.builder()
				.productId(productId)
				.name(name)
				.price(price)
				.size(size)
				.build();
	}
}
