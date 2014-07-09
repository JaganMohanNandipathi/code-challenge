package com.aaronhible.savvis.model;

import java.util.UUID;

import org.junit.Test;

import junit.framework.TestCase;

public class EmployeeTestCase extends TestCase {
	
	@Test
	public void testCreateEmployee() {
		String employeeId = UUID.randomUUID().toString();
		EmployeeType employeeType = new QATesterType(Type.QA_TESTER);
		
		Employee employee = new Employee(employeeId, employeeType);
		
		assertEquals(employee.getEmployeeId(), employeeId);
		assertEquals(employeeType.getType(), employee.getType());
		
	}
}
