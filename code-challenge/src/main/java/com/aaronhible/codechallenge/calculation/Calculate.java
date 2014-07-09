package com.aaronhible.codechallenge.calculation;

import java.math.BigDecimal;

import com.aaronhible.codechallenge.domain.department.model.Department;
import com.aaronhible.codechallenge.domain.employee.model.Employee;

public class Calculate {
	public static BigDecimal sumAllocations(Employee employee) {
		BigDecimal total = employee.getExpenseAllocation();
		// for each report add the allocation, if no reports (leaf)
		// then this is skipped
		for (Employee directReport : employee.getReports()) {
			total = total.add(sumAllocations(directReport));
		}
		return total;
	}

	public static BigDecimal sumAllocations(Department rockStart) {
		return sumAllocations(rockStart.getManager());
	}

}
