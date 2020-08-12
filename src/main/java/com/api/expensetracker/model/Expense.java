package com.api.expensetracker.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "expense")
public class Expense implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int expense_id;

	@Column
	private String description;

	@Column
	private BigDecimal expense_amount;
	
	@Column
	private Date expense_date;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User users;
}
