package com.aaronhible.codechallenge.domain.department.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.aaronhible.codechallenge.domain.employee.model.Employee;
import com.aaronhible.codechallenge.test.util.DepartmentUtil;

public class OrganizationTestCase {
	
	/**
	 * UseCase (Implied): Departments consist of any kinds of employees.
	 */
	@Test
	public void departmentsConsistOfAnyKindsOfEmployees() {
		//expect
		int numberOfEmployees = 43;
		
		//setup
		Organization organization = new Organization();
		Department rockStart = DepartmentUtil.createRockStarDepartment();
		Department ops = DepartmentUtil.createOperationsDepartment();

		//action
		organization.add(rockStart);
		organization.add(ops);

		int totalEmployees = sumEmployees(organization);
		
		//assert
		assertEquals(numberOfEmployees, totalEmployees);
		
	}

	private int sumEmployees(Organization organization) {
		int total = 0;
		for (Department depart : organization.getAllDepartments()) {
			total += sumEmployees(depart.getManager());
		}
		return total;
	}

	private int sumEmployees(Employee employee) {
		int total = 1;
		for (Employee directReport : employee.getReports()) {
			total = total + sumEmployees(directReport);
		}
		return total;
	}
	
}
