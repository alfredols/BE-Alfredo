package br.com.api.order.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="user_order")
public class Order implements Serializable{ 
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
		
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "item_description")
	private String itemDescription;
	
	@Column(name = "item_quantity")
	private int itemQuantity;
	
	@Column(name = "item_price")
	private BigDecimal itemPrice;
	
	@Column(name = "total_value")
	private BigDecimal totalValue;
	
	@Column(name = "created_at")
	private Date  createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;	
		
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return userId;
	}

	public void setUser_id(Long user_id) {
		this.userId = user_id;
	}

	public String getItem_description() {
		return itemDescription;
	}

	public void setItem_description(String item_description) {
		this.itemDescription = item_description;
	}

	public int getItem_quantity() {
		return itemQuantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.itemQuantity = item_quantity;
	}

	public BigDecimal getItem_price() {
		return itemPrice;
	}

	public void setItem_price(BigDecimal item_price) {
		this.itemPrice = item_price;
	}

	public BigDecimal getTotal_value() {
		return totalValue;
	}

	public void setTotal_value(BigDecimal total_value) {
		this.totalValue = total_value;
	}

	public Date getCreated_at() {
		return createdAt;
	}

	public void setCreated_at(Date created_at) {
		this.createdAt = created_at;
	}

	public Date getUpdated_at() {
		return updatedAt;
	}

	public void setUpdated_at(Date updated_at) {
		this.updatedAt = updated_at;
	}	
}


