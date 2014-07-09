package com.aaronhible.codechallenge.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Test;

import com.aaronhible.codechallenge.model.DeveloperType;
import com.aaronhible.codechallenge.model.Employee;
import com.aaronhible.codechallenge.model.EmployeeId;
import com.aaronhible.codechallenge.model.ManagerType;
import com.aaronhible.codechallenge.model.QATesterType;

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

	/**
	 * UseCase: Managers warrant an allocation of $3300 each.
	 */
	@Test
	public void managerWarrantAllocation() {
		// expected
		BigDecimal expectedAllocation = new BigDecimal(300);

		// setup / action
		EmployeeId employeeId = new EmployeeId();
		Employee employee = new Employee(employeeId, new ManagerType());

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee.getEmployeeType() instanceof ManagerType);
		assertEquals(expectedAllocation, employee.getEmployeeType()
				.getExpenseAllocation());

	}

	/**
	 * UseCase: Managers can have QA Testers, Developers and other managers
	 * report to them.
	 */
	@Test
	public void managersCanHaveQATestersDeveloperManagerReports() {
		// expected
		Employee irisManager = new Employee(new EmployeeId(), new ManagerType());
		Employee ryeDeveloper = new Employee(new EmployeeId(),
				new DeveloperType());
		Employee bruceQATester = new Employee(new EmployeeId(),
				new QATesterType());

		// setup
		Employee jtManager = new Employee(new EmployeeId(), new ManagerType());

		// action
		jtManager.addReport(irisManager);
		jtManager.addReport(ryeDeveloper);
		jtManager.addReport(bruceQATester);
		Collection<Employee> reports = jtManager.getReports();

		// assert
		assertTrue(reports.contains(irisManager));
		assertTrue(reports.contains(ryeDeveloper));
		assertTrue(reports.contains(bruceQATester));

	}
}
