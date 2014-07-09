package com.aaronhible.savvis.model;

import java.math.BigDecimal;


public abstract class EmployeeType {
	/**
	 * Returns the expense allocation amount for the employee type.
	 * This is a BigDecimal since expenses are in dollars.
	 * 
	 * @return BigDecimal
	 */
	public abstract BigDecimal getExpenseAllocation();
}
