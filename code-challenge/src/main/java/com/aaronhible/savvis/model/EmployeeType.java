package com.aaronhible.savvis.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class EmployeeType {

	protected Set<Employee> reports = new HashSet<Employee>();

	/**
	 * Returns the expense allocation amount for the employee type. This is a
	 * BigDecimal since expenses are in dollars.
	 * 
	 * @return BigDecimal
	 */
	public abstract BigDecimal getExpenseAllocation();

	public abstract void addReport(Employee employee);

	public Collection<Employee> getReports() {
		return Collections.unmodifiableSet(reports);
	}
}
