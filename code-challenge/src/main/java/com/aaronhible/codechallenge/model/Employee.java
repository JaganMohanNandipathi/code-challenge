package com.aaronhible.codechallenge.model;

import java.util.Collection;

public interface Employee {

	public EmployeeId getEmployeeId();

	public void addReport(Employee employee);

	public Collection<Employee> getReports();
}
