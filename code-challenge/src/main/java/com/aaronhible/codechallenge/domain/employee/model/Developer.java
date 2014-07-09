package com.aaronhible.codechallenge.domain.employee.model;

import static com.aaronhible.codechallenge.util.ExceptionUtils.illegalStateException;

import java.math.BigDecimal;

public class Developer extends Employee {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(1000);

	public Developer(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public BigDecimal getExpenseAllocation() {
		return EXPENSE_ALLOCATION;
	}

	@Override
	public void addReport(Employee employee) {
		illegalStateException(employee, this);
	}

	@Override
	public EmployeeId getEmployeeId() {
		return employeeId;
	}

}
