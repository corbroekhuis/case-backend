package org.eijsink.model;

import jakarta.persistence.*;

@Entity
public class Payment{

	public enum PAYMENT_TYPE { CASH, CARD}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double amount;
	private PAYMENT_TYPE type;

	public Payment() {
	}

	public Payment(double amount, PAYMENT_TYPE type) {
		this.amount = amount;
		this.type = type;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}
	public double getAmount(){ 
		return amount;
	}
	public void setAmount( double amount){
		this.amount = amount;
	}
	public PAYMENT_TYPE getType(){
		return type;
	}
	public void setType( PAYMENT_TYPE type){
		this.type = type;
	}

}
