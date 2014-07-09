package com.aaronhible.savvis.model;

public class Employee {
	private final String employeeId;

	private final EmployeeType employeeType;

	public Employee(String employeeId, EmployeeType employeeType) {
		this.employeeId = employeeId;
		this.employeeType = employeeType;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}

	public Type getType() {
		return employeeType.getType();
	}

}
