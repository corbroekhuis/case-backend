package org.eijsink.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private MainOrder mainOrder;
	@OneToMany
	private List<Payment> payments = new ArrayList<>();
	private boolean closed;

	public long getId(){ 
		return id;
	}
	public void setId( long id){
		this.id = id;
	}
	public MainOrder getMainOrder(){ 
		return mainOrder;
	}
	public void setMainOrder( MainOrder mainOrder){
		this.mainOrder = mainOrder;
	}
	public List<Payment> getPayments(){
		return payments;
	}
	public void addPayment( Payment payment){
		this.payments.add( payment);
	}
	public boolean getClosed(){ 
		return closed;
	}
	public void setClosed( boolean closed){
		this.closed = closed;
	}

}
