package com.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_books")
public class MyBookEntity {
	@Id
	private Long id;
	private String name;
	private String author;
	private String price;
}
