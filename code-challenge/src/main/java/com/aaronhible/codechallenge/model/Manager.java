package com.aaronhible.codechallenge.model;

import java.math.BigDecimal;

public class Manager extends Employee {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(300);

	public Manager(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public BigDecimal getExpenseAllocation() {
		return EXPENSE_ALLOCATION;
	}

	@Override
	public void addReport(Employee employee) {
		reports.add(employee);
	}

	@Override
	public EmployeeId getEmployeeId() {
		return employeeId;
	}

}
