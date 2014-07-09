package com.aaronhible.codechallenge.domain.employee.model;

import com.aaronhible.codechallenge.domain.Id;

/**
 * Unique identifier of the Employee 
 *
 */
public class EmployeeId extends Id{
	
	@Override
	public String toString() {
		return "EmployeeId [employeeId=" + id + "]";
	}
	
	
}
