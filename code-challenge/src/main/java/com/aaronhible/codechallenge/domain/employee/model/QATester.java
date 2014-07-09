package com.aaronhible.codechallenge.domain.employee.model;

import static com.aaronhible.codechallenge.util.ExceptionUtil.illegalStateException;

import java.math.BigDecimal;

/**
 * Represents a QATester.  Logically this is the "Leaf" of the GoF Composite Design Pattern.
 *
 */
public class QATester extends Employee {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(500);

	public QATester(EmployeeId employeeId) {
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

	@Override
	public String toString() {
		return this.getClass().getName() + " [employeeId=" + employeeId + ", reports=" + reports
				+ "]";
	}

}
