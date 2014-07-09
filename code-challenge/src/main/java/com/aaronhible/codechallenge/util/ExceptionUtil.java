package com.aaronhible.codechallenge.util;

import com.aaronhible.codechallenge.domain.employee.model.Employee;

/**
 * Helper class to encapsulate common exception generation.
 * 
 */
public class ExceptionUtil {
	public static void illegalStateException(Employee employee, Employee target) {
		throw new IllegalStateException("Cannot add "
				+ employee.getClass().getSimpleName() + " to "
				+ target.getClass().getSimpleName());
	}

}
