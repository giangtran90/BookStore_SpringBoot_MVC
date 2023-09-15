package com.bookStore.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private Long id;
	@Size(min=2, max=30)
	@Pattern(regexp = "^[a-zA-Z0-9 ]*",message = "Please input the digits from a->z or A->Z")
	private String name;
	private String author;
	private String price;
}
