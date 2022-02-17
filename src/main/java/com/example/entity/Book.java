package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private int price;
	private int discountPrice;
	private int stock;
	
	public Book(String title, String author, String publisher, String description, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.description = description;
		this.price = price;
		this.discountPrice = (int) (price*0.9);
		this.stock = 20;
	}
	
}
