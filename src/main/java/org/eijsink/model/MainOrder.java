package org.eijsink.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MainOrder{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String orderNumber;
	private LocalDate orderDate;
	@ManyToOne
	private Ober ober;
	@OneToMany
	private List<OrderRound> orderRounds = new ArrayList<>();
	@OneToMany
	private List<Payment> payments = new ArrayList<>();
	private boolean closed;

	public MainOrder() {
	}

	public MainOrder(String orderNumber, LocalDate orderDate, Ober ober) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.ober = ober;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}
	public String getOrderNumber(){ 
		return orderNumber;
	}
	public void setOrderNumber( String orderNumber){
		this.orderNumber = orderNumber;
	}
	public LocalDate getOrderDate(){ 
		return orderDate;
	}
	public void setOrderDate( LocalDate orderDate){
		this.orderDate = orderDate;
	}
	public Ober getOber(){
		return ober;
	}
	public void setOber( Ober ober){
		this.ober = ober;
	}
	public List<OrderRound> getOrderRounds(){ 
		return orderRounds;
	}
	public void addOrderRound( OrderRound orderRound){
		this.orderRounds.add(orderRound);
	}
	public List<Payment> getPayments(){ 
		return payments;
	}
	public void addPayment( Payment payments){
		this.payments.add(payments);
	}
	public boolean getClosed(){ 
		return closed;
	}
	public void setClosed( boolean closed){
		this.closed = closed;
	}

}
