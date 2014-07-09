package com.aaronhible.savvis.model;

import java.math.BigDecimal;

public class ManagerType extends EmployeeType {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(300);

	@Override
	public BigDecimal getExpenseAllocation() {
		return EXPENSE_ALLOCATION;
	}

	@Override
	public void addReport(Employee employee) {
		reports.add(employee);
	}

}
