package com.aaronhible.codechallenge.domain.employee.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Test;

import com.aaronhible.codechallenge.domain.employee.model.Developer;
import com.aaronhible.codechallenge.domain.employee.model.Employee;
import com.aaronhible.codechallenge.domain.employee.model.EmployeeId;
import com.aaronhible.codechallenge.domain.employee.model.Manager;
import com.aaronhible.codechallenge.domain.employee.model.QATester;

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
		Employee employee = new QATester(employeeId);

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof QATester);
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
		Employee employee = new Developer(employeeId);

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof Developer);
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
		Employee employee = new Manager(employeeId);

		// assert
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof Manager);
		assertEquals(expectedAllocation, employee.getExpenseAllocation());

	}

	/**
	 * UseCase: Managers can have QA Testers, Developers and other managers
	 * report to them.
	 */
	@Test
	public void managersCanHaveQATestersDeveloperManagerReports() {
		// expected
		Employee irisManager = new Manager(new EmployeeId());
		Employee ryeDeveloper = new Developer(new EmployeeId());
		Employee bruceQATester = new QATester(new EmployeeId());

		// setup
		Employee jtManager = new Manager(new EmployeeId());

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

	/**
	 * UserCase (Implied): QA Testers cannot have reports.
	 */
	@Test(expected = IllegalStateException.class)
	public void qaTestersCannotHaveReports() {
		// setup
		// qa testers love to manage developers but they can't!
		Employee bruceQATester = new QATester(new EmployeeId());
		Employee ryeDeveloper = new Developer(new EmployeeId());

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
		Employee ryeDeveloper = new Developer(new EmployeeId());
		Employee bruceQATester = new QATester(new EmployeeId());

		// action
		ryeDeveloper.addReport(bruceQATester);

		// assert (expect exception)

	}

	/**
	 * UseCase (Implied): Manager cannot manage themselves.
	 */
	@Test(expected = IllegalStateException.class)
	public void managerCannotManageThemself() {
		// setup
		// developers so wish they could manage qa testers
		Employee irisManager = new Manager(new EmployeeId());

		// action
		irisManager.addReport(irisManager);

		// assert (expect exception)

	}

}
