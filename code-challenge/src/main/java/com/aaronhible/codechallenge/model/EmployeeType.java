package com.aaronhible.codechallenge.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class EmployeeType {

	protected EmployeeId employeeId;

	protected Set<EmployeeType> reports = new HashSet<EmployeeType>();

	/**
	 * Returns the expense allocation amount for the employee type. This is a
	 * BigDecimal since expenses are in dollars.
	 * 
	 * @return BigDecimal
	 */
	public abstract BigDecimal getExpenseAllocation();

	public abstract void addReport(EmployeeType employee);

	public abstract EmployeeId getEmployeeId();

	public Collection<EmployeeType> getReports() {
		return Collections.unmodifiableSet(reports);
	}
}
