package org.eijsink.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderRound{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany
	List<OrderRoundItem> orderRoundItems = new ArrayList<>();

	public OrderRound() {
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}

	public List<OrderRoundItem> getOrderRoundItems() {
		return orderRoundItems;
	}

	public void addOrderRoundItem(OrderRoundItem orderRoundItem) {
		this.orderRoundItems.add( orderRoundItem);
	}
	public void addOrderRoundItem(OrderRoundItem orderRoundItem, int count) {
		for( int i = 0; i < count; i++){
			this.orderRoundItems.add(orderRoundItem);
		}
	}
}
