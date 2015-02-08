package com.bloc.interfaces.people;

import com.bloc.interfaces.people.hobbies.SalsaDancer;

/************************************************
 *	ASSIGNMENT:
 *	Have Albert implement the SalsaDancer interface
/************************************************/

public class Albert extends Person implements SalsaDancer {
	public Albert() {
		super("Albert", "Cobb", "Male", 1.8d, 72d, "Green");
	}
	
	public void putOnShoes(){
		//Empty
	}
	
	public void findAPartner(){
		//Empty
	}
	
	public void salsa(){
		//Empty
	}
}