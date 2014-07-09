package com.aaronhible.codechallenge.util;

import com.aaronhible.codechallenge.model.EmployeeType;

public class ExceptionUtils {
	public static void illegalStateException(EmployeeType employee,
			EmployeeType target) {
		throw new IllegalStateException("Cannot add "
				+ employee.getClass().getSimpleName() + " to "
				+ target.getClass().getSimpleName());
	}

}
