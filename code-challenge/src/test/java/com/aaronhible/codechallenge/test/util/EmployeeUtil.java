package com.aaronhible.codechallenge.test.util;

import com.aaronhible.codechallenge.domain.employee.model.Developer;
import com.aaronhible.codechallenge.domain.employee.model.Employee;
import com.aaronhible.codechallenge.domain.employee.model.EmployeeId;
import com.aaronhible.codechallenge.domain.employee.model.Manager;
import com.aaronhible.codechallenge.domain.employee.model.QATester;

public class EmployeeUtil {

	public static Manager createManager() {
		return new Manager(new EmployeeId());
	}

	public static Developer createDeveloper() {
		return new Developer(new EmployeeId());
	}

	public static QATester createQATester() {
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

	public static Manager createManagerWithReports(int developers,
			int qatesters) {
		Manager manager = createManager();
		for (int j = 0; j < developers; j++) {
			manager.addReport(createDeveloper());
		}
		for (int j = 0; j < qatesters; j++) {
			manager.addReport(createQATester());
		}
		return manager;
	}

}
