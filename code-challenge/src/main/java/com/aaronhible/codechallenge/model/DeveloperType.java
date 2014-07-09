package com.aaronhible.codechallenge.model;

import java.math.BigDecimal;

public class DeveloperType extends EmployeeType {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(1000);

	public DeveloperType(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public BigDecimal getExpenseAllocation() {
		return EXPENSE_ALLOCATION;
	}

	@Override
	public void addReport(EmployeeType employee) {
		throw new IllegalStateException("Cannot add "
				+ Employee.class.getSimpleName() + " to "
				+ this.getClass().getSimpleName());
	}

	@Override
	public EmployeeId getEmployeeId() {
		return employeeId;
	}

}
