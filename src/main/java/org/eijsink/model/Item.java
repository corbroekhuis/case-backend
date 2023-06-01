package org.eijsink.model;

import jakarta.persistence.*;

@Entity
public class Item{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String itemId;
	private String name;
	private double price;

	public Item() {
	}

	public Item(String itemId, String name, double price) {
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}
	public String getItemId(){ 
		return itemId;
	}
	public void setItemId( String itemId){
		this.itemId = itemId;
	}
	public String getName(){ 
		return name;
	}
	public void setName( String name){
		this.name = name;
	}
	public double getPrice(){ 
		return price;
	}
	public void setPrice( double price){
		this.price = price;
	}

}
