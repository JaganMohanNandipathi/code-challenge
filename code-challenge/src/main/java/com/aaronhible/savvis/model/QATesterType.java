package com.aaronhible.savvis.model;

import java.math.BigDecimal;

public class QATesterType extends EmployeeType {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(500);

	public QATesterType() {
	}

	@Override
	public BigDecimal getExpenseAllocation() {
		return EXPENSE_ALLOCATION;
	}

	@Override
	public void addReport(Employee employee) {
		throw new IllegalStateException("Cannot add "
				+ Employee.class.getSimpleName() + " to "
				+ this.getClass().getSimpleName());
	}

}
