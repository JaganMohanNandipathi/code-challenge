package com.aaronhible.codechallenge.domain.employee.model;

import static com.aaronhible.codechallenge.util.ExceptionUtil.illegalStateException;

import java.math.BigDecimal;

/**
 * Represents a manager. This class represents the "Composite" of the GoF
 * Composite Design Pattern.
 * 
 */
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
		if (this.equals(employee))
			illegalStateException(employee, this);
		reports.add(employee);
	}

	@Override
	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [employeeId=" + employeeId
				+ ", reports=" + reports + "]";
	}

}
