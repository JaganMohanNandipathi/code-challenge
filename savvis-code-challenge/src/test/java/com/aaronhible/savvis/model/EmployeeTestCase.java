package com.aaronhible.savvis.model;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.junit.Test;

public class EmployeeTestCase extends TestCase {

	/**
	 * UseCase: QA Testers warrant an allocation of $500 each.
	 */
	@Test
	public void qaTesterEmployeeTypeShouldHaveExpenseAllocation() {

		EmployeeId employeeId = new EmployeeId();
		Employee employee = new Employee(employeeId, new QATesterType());

		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee.getEmployeeType() instanceof QATesterType);
		assertEquals(new BigDecimal(500), employee.getEmployeeType().getExpenseAllocation());

	}
	
	
}
