package com.bookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBook {
	private Long id;
	private String name;
	private String author;
	private String price;
}
