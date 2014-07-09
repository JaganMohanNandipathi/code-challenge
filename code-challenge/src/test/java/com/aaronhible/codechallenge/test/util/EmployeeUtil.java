package com.aaronhible.codechallenge.test.util;

import com.aaronhible.codechallenge.model.Developer;
import com.aaronhible.codechallenge.model.Employee;
import com.aaronhible.codechallenge.model.EmployeeId;
import com.aaronhible.codechallenge.model.Manager;
import com.aaronhible.codechallenge.model.QATester;

public class EmployeeUtil {

	public static Employee createManager() {
		return new Manager(new EmployeeId());
	}

	public static Employee createDeveloper() {
		return new Developer(new EmployeeId());
	}

	public static Employee createQATester() {
		return new QATester(new EmployeeId());
	}

	/**
	 * For the given hierarchy: 
	 * I. Manager A 
	 *    A. Manager B 
	 *    		1. Developer 
	 *    		2. QATester
	 * 
	 * @return
	 */
	public static Employee createExampleScenario() {
		Employee managerA = new Manager(new EmployeeId());
		Employee managerB = new Manager(new EmployeeId());
		Employee developer = new Developer(new EmployeeId());
		Employee qatester = new QATester(new EmployeeId());

		managerB.addReport(developer);
		managerB.addReport(qatester);
		managerA.addReport(managerB);

		return managerA;
	}
}
