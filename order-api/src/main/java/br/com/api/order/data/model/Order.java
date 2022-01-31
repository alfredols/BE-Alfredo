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
	
	@Column(nullable = false, length = 100)
	private Long user_id;

	@Column(nullable = false, length = 11)
	private String item_description;
	
	@Column(nullable = true, length = 100)
	private int item_quantity;
	
	@Column(nullable = true)
	private BigDecimal item_price;
	
	@Column(nullable = true)
	private BigDecimal total_value;
	
	@Column(nullable = true)
	private Date  created_at;

	@Column(nullable = true)
	private Date updated_at;	
		
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public BigDecimal getItem_price() {
		return item_price;
	}

	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}

	public BigDecimal getTotal_value() {
		return total_value;
	}

	public void setTotal_value(BigDecimal total_value) {
		this.total_value = total_value;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}	
}


