package com.aaronhible.codechallenge.test.util;

import com.aaronhible.codechallenge.domain.department.model.Organization;

public class OrganizationUtil {
	public static Organization createOrganization() {
		Organization organization = new Organization();
		organization.add(DepartmentUtil.createOperationsDepartment());
		organization.add(DepartmentUtil.createRockStarDepartment());
		return organization;
	}
}
