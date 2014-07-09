package com.aaronhible.codechallenge.calculation;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.aaronhible.codechallenge.domain.department.model.Department;
import com.aaronhible.codechallenge.domain.employee.model.Employee;
import com.aaronhible.codechallenge.test.util.DepartmentUtil;
import com.aaronhible.codechallenge.test.util.EmployeeUtil;

public class CalculateTestCase {

	/**
	 * UseCase:
	 * 
	 * Example Scenario - For the given hierarchy:
	 * I. Manager A 
	 *    A. Manager B 
	 *    		1. Developer 
	 *    		2. QATester
	 * Manager A’s allocation should be: $2100
	 */
	@Test
	public void exampleScenario() {
		BigDecimal managerAsAllocation = new BigDecimal(2100);

		//setup
		Employee managerA = EmployeeUtil.createExampleScenario();
		
		//action
		BigDecimal total = Calculate.sumAllocations(managerA);
		
		//assert
		assertEquals(managerAsAllocation, total);
	}
	
	/**
	 * UseCase: Determine the monthly expense allocation warranted a department
	 * with various employee types under it at multiple levels deep just as the
	 * Manager can.
	 */
	@Test
	public void sumRockStartDepartmentAllocations() {
		/*
		 * Managers - 300 * 4
		 * Developers - 1000 * 7
		 * QATesters - 500 * 8
		 * Total = 12200
		 */
		BigDecimal rockStarAllocation = new BigDecimal(12200);
		
		//setup
		Department rockStar = DepartmentUtil.createRockStarDepartment();
		
		//Action
		BigDecimal total = Calculate.sumAllocations(rockStar);
		
		//assert
		assertEquals(rockStarAllocation, total);
	}
	
	@Test
	public void sumOperationsDepartmentAllocations() {
		/*
		 * Managers - 300 * 4
		 * Developers - 1000 * 10
		 * QATesters - 500 * 10
		 * Total = 16200
		 */
		BigDecimal operationsAllocation = new BigDecimal(16200);
		
		//setup
		Department operations = DepartmentUtil.createOperationsDepartment();
		
		//Action
		BigDecimal total = Calculate.sumAllocations(operations);
		
		//assert
		assertEquals(operationsAllocation, total);
	}
	
	@Test
	public void sumOrganizationAllocations() {
		/*
		 * RockStart = 12200
		 * Operations = 16200
		 * Total = 28400
		 */
		BigDecimal totalAllocation = new BigDecimal(28400);
		
		//setup
		Department rockStar = DepartmentUtil.createRockStarDepartment();
		Department operations = DepartmentUtil.createOperationsDepartment();
		
		//Action
		BigDecimal total = Calculate.sumAllocations(rockStar);
		total = total.add(Calculate.sumAllocations(operations));
		
		//assert
		assertEquals(totalAllocation, total);
	}


}
