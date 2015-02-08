package com.bloc.interfaces.people;

import com.bloc.interfaces.people.hobbies.Skydiver;

/************************************************
 *	ASSIGNMENT:
 *	Have Mary implement the Skydiver interface
/************************************************/

public class Mary extends Person implements Skydiver{
	public Mary() {
		super("Mary", "Whiters", "Female", 1.65d, 62d, "Blue");
	}
	
	public void getInPlane(){
		//Empty
	}
	
	public void jumpFromPlane(){
		//Empty
	}
	
	public void releaseParachute(){
		//Empty
	}
}