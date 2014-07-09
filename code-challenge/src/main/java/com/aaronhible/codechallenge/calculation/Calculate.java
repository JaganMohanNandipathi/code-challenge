package com.aaronhible.codechallenge.calculation;

import java.math.BigDecimal;

import com.aaronhible.codechallenge.domain.department.model.Department;
import com.aaronhible.codechallenge.domain.employee.model.Employee;

/**
 * Calculate handles stack only operations (static) for returning a result based
 * on an input.
 * 
 */
public class Calculate {

	/**
	 * Recursively sums the Expense Allocation for each employee and the reports
	 * for any of the reports employees.
	 * 
	 * @param employee
	 * @return BigDecimal (Used for Dollar precision)
	 */
	public static BigDecimal sumAllocations(Employee employee) {
		BigDecimal total = employee.getExpenseAllocation();
		// for each report add the allocation, if no reports (leaf)
		// then this is skipped
		for (Employee directReport : employee.getReports()) {
			total = total.add(sumAllocations(directReport));
		}
		return total;
	}

	/**
	 * Starting at the department manager, recursively sums the Expense
	 * Allocation for each employ.
	 * 
	 * @param departments
	 * @return BigDecimal (Used for Dollar precision)
	 */
	public static BigDecimal sumAllocations(Department department) {
		return sumAllocations(department.getManager());
	}

}
