package com.aaronhible.savvis.model;


public class QATesterType extends EmployeeType {

	private final Type employeeType; 
	
	public QATesterType (Type employeeType) {
		this.employeeType = employeeType;
	}
	
	@Override
	public Type getType() {
		return employeeType;
	}

}
