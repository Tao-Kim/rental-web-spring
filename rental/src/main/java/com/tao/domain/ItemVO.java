package com.tao.domain;

import lombok.Data;

@Data
public class ItemVO {
	private Long ino;
	private String category1;
	private String category2;
	private String title;
	private String itemFee;
	private String itemName;
	private String itemFeatures;
	private String itemSize;
	private String information;

	private String itemImg;
	private String itemThumbImg;
	private String itemDetailImg;
}
