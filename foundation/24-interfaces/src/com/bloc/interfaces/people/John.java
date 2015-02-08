package com.bloc.interfaces.people;

import com.bloc.interfaces.people.hobbies.Driver;

/************************************************
 *	ASSIGNMENT:
 *	Have John implement the Driver interface
/************************************************/

public class John extends Person implements Driver {
	public John() {
		super("John", "Smith", "Male", 1.7d, 69d, "Brown");
	}
	
	public void getInCar(){
		//Empty
	}
	
	public void startEngine(){
		//empty
	}
	
	public void driveFast(){
		//empty
	}
}