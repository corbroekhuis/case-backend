package org.eijsink.model;

import jakarta.persistence.*;

@Entity
public class OrderRoundItem{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Item item;
	private int count;

	public OrderRoundItem() {
	}

	public OrderRoundItem(Item item, int count) {
		this.item = item;
		this.count = count;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}
	public Item getItem(){ 
		return item;
	}
	public void setItem( Item item){
		this.item = item;
	}
	public int getCount(){ 
		return count;
	}
	public void setCount( int count){
		this.count = count;
	}

}
