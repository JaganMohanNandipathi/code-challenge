package com.aaronhible.codechallenge.domain.employee.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents an Employee. Though not an interface, this class represents the
 * "Component" of the GoF Composite Design Pattern.
 * 
 */
public abstract class Employee {

	protected EmployeeId employeeId;

	protected Set<Employee> reports = new HashSet<Employee>();

	/**
	 * Returns the expense allocation amount for the employee type. This is a
	 * BigDecimal since expenses are in dollars.
	 * 
	 * @return BigDecimal
	 */
	public abstract BigDecimal getExpenseAllocation();

	public abstract void addReport(Employee employee);

	public abstract EmployeeId getEmployeeId();

	public Collection<Employee> getReports() {
		return Collections.unmodifiableSet(reports);
	}
}
