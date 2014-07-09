package com.aaronhible.codechallenge.test.util;

import com.aaronhible.codechallenge.domain.department.model.Department;
import com.aaronhible.codechallenge.domain.department.model.DepartmentId;
import com.aaronhible.codechallenge.domain.employee.model.Manager;

public class DepartmentUtil {
	/**
	 * RockStar Department - 
	 * I. Department Head
	 * 		A. Manager A
	 *      	1. Manager B
	 *      		a. (2) Developer
	 *              b. (3) QA Tester
	 *          2. (4) Developer
	 *          3. (1) QA Tester
	 *      B. Manager C
	 *      	1. (1) Developer
	 *          2. (4) QA Tester
	 *  
	 *  19 Employees
	 * @return
	 */
	public static Department createRockStarDepartment() {
		Manager departmentHead = EmployeeUtil.createManager();
		
		Manager managera = EmployeeUtil.createManagerWithReports(4, 1);
		Manager managerb = EmployeeUtil.createManagerWithReports(2, 3);
		Manager managerc = EmployeeUtil.createManagerWithReports(1, 4);
		
		//managerb reports to a
		managera.addReport(managerb);
		departmentHead.addReport(managera);
		departmentHead.addReport(managerc);

		Department rockStar = new Department(new DepartmentId(), departmentHead);
		return rockStar;
	}
	
	/**
	 * RockStar Department - 
	 * I. Department Head
	 * 		A. Manager A
	 *      	1. Manager B
	 *      		a. Manager C
     *				   i. (10) Developer
     *                 ii. (10) QATester 
	 *  
	 *  24 Employees
	 * @return
	 */
	public static Department createOperationsDepartment() {
		Manager departmentHead = EmployeeUtil.createManager();

		Manager managera = EmployeeUtil.createManager();
		Manager managerb = EmployeeUtil.createManager();
		Manager managerc = EmployeeUtil.createManagerWithReports(10, 10);

		departmentHead.addReport(managera);
		managera.addReport(managerb);
		managerb.addReport(managerc);

		Department operations = new Department(new DepartmentId(), departmentHead);
		return operations;
	}
	

}
