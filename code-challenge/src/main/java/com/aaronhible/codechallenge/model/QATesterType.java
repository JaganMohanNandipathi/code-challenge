package com.aaronhible.codechallenge.model;

import static com.aaronhible.codechallenge.util.ExceptionUtils.illegalStateException;

import java.math.BigDecimal;

public class QATesterType extends EmployeeType {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(500);

	public QATesterType(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public BigDecimal getExpenseAllocation() {
		return EXPENSE_ALLOCATION;
	}

	@Override
	public void addReport(EmployeeType employee) {
		illegalStateException(employee, this);
	}


	@Override
	public EmployeeId getEmployeeId() {
		return employeeId;
	}

}
