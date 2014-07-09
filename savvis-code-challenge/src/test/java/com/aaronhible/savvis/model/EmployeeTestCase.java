package com.aaronhible.savvis.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class EmployeeTestCase {

	/**
	 * UseCase: QA Testers warrant an allocation of $500 each.
	 */
	@Test
	public void qaTesterTestersWarrantAllocation() {

		// expected
		BigDecimal expectedAllocation = new BigDecimal(500);

		// setup / action
		EmployeeId employeeId = new EmployeeId();
		Employee employee = new Employee(employeeId, new QATesterType());

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee.getEmployeeType() instanceof QATesterType);
		assertEquals(expectedAllocation, employee.getEmployeeType()
				.getExpenseAllocation());

	}

	/**
	 * UseCase: Developers warrant an allocation of $1000 each.
	 */
	@Test
	public void developersWarrantAllocation() {
		// expected
		BigDecimal expectedAllocation = new BigDecimal(1000);

		// setup / action
		EmployeeId employeeId = new EmployeeId();
		Employee employee = new Employee(employeeId, new DeveloperType());

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee.getEmployeeType() instanceof DeveloperType);
		assertEquals(expectedAllocation, employee.getEmployeeType()
				.getExpenseAllocation());
	}

}
