package com.aaronhible.codechallenge.domain.department.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * An organization is a composed of multiple unique departments. 
 *
 */
public class Organization {
	private final Set<Department> departments = new HashSet<Department>();

	public Organization() {
	}

	public Collection<Department> getAllDepartments() {
		return Collections.unmodifiableSet(departments);
	}

	public void add(Department department) {
		departments.add(department);
	}

}
