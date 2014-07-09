package com.aaronhible.codechallenge.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

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
		EmployeeType employee = new QATesterType(employeeId);

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof QATesterType);
		assertEquals(expectedAllocation, employee.getExpenseAllocation());

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
		EmployeeType employee = new DeveloperType(employeeId);

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof DeveloperType);
		assertEquals(expectedAllocation, employee.getExpenseAllocation());
	}

	/**
	 * UseCase: Managers warrant an allocation of $3300 each.
	 */
	@Test
	public void managerWarrantAllocation() {
		// expected
		BigDecimal expectedAllocation = new BigDecimal(300);

		// setup / action
		EmployeeId employeeId = new EmployeeId();
		EmployeeType employee = new ManagerType(employeeId);

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof ManagerType);
		assertEquals(expectedAllocation, employee.getExpenseAllocation());

	}

	/**
	 * UseCase: Managers can have QA Testers, Developers and other managers
	 * report to them.
	 */
	@Test
	public void managersCanHaveQATestersDeveloperManagerReports() {
		// expected
		EmployeeType irisManager = new ManagerType(new EmployeeId());
		EmployeeType ryeDeveloper = new DeveloperType(new EmployeeId());
		EmployeeType bruceQATester = new QATesterType(new EmployeeId());

		// setup
		EmployeeType jtManager = new ManagerType(new EmployeeId());

		// action
		jtManager.addReport(irisManager);
		jtManager.addReport(ryeDeveloper);
		jtManager.addReport(bruceQATester);
		Collection<EmployeeType> reports = jtManager.getReports();

		// assert
		assertTrue(reports.contains(irisManager));
		assertTrue(reports.contains(ryeDeveloper));
		assertTrue(reports.contains(bruceQATester));

	}

	/**
	 * UserCase (Implied): QA Testers cannot have reports.
	 */
	@Test(expected = IllegalStateException.class)
	public void qaTestersCannotHaveReports() {
		// setup
		// qa testers love to manage developers but they can't!
		EmployeeType bruceQATester = new QATesterType(new EmployeeId());
		EmployeeType ryeDeveloper = new DeveloperType(new EmployeeId());

		// action
		bruceQATester.addReport(ryeDeveloper);

		// assert (expect exception)
	}

	/**
	 * UseCase (Implied): Developers cannot have reports.
	 */
	@Test(expected = IllegalStateException.class)
	public void developersCannotHaveReports() {
		// setup
		// developers so wish they could manage qa testers
		EmployeeType ryeDeveloper = new DeveloperType(new EmployeeId());
		EmployeeType bruceQATester = new QATesterType(new EmployeeId());

		// action
		ryeDeveloper.addReport(bruceQATester);

		// assert (expect exception)

	}
}
