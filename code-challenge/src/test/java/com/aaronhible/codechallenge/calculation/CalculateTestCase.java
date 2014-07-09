package com.aaronhible.codechallenge.calculation;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.aaronhible.codechallenge.model.Employee;
import com.aaronhible.codechallenge.test.util.EmployeeUtil;

public class CalculateTestCase {

	/**
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
		Employee managerA = EmployeeUtil.createExampleScenario();
		BigDecimal total = Calculate.sumAllocations(managerA);
		assertEquals(managerAsAllocation, total);
	}

}
