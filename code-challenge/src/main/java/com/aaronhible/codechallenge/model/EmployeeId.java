package com.aaronhible.codechallenge.model;

import java.util.UUID;

public class EmployeeId {
	private final String employeeId;
	
	public EmployeeId() {
		employeeId = UUID.randomUUID().toString();
	}
	
	public EmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeId() {
		return this.employeeId;
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
		EmployeeId other = (EmployeeId) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeId [employeeId=" + employeeId + "]";
	}
	
	
}
