package com.aaronhible.savvis.model;

public class Employee {
	private final EmployeeId employeeId;

	private final EmployeeType employeeType;

	public Employee(EmployeeId employeeId, EmployeeType employeeType) {
		this.employeeId = employeeId;
		this.employeeType = employeeType;
	}

	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	public EmployeeType getEmployeeType() {
		return this.employeeType;
	}
}
