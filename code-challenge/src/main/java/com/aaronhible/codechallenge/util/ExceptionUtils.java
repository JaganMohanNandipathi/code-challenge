package com.aaronhible.codechallenge.util;

import com.aaronhible.codechallenge.model.Employee;

public class ExceptionUtils {
	public static void illegalStateException(Employee employee,
			Employee target) {
		throw new IllegalStateException("Cannot add "
				+ employee.getClass().getSimpleName() + " to "
				+ target.getClass().getSimpleName());
	}

}
