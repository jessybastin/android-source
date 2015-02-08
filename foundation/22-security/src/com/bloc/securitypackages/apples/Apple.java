package com.bloc.securitypackages.apples;

import com.bloc.securitypackages.Color;
import com.bloc.securitypackages.Fruit;
import com.bloc.securitypackages.colors.Red;

/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

abstract class Apple extends Fruit {

	
 Apple(String name, int calories, Color color, double weight) {   	
		super(name, calories, color,weight);
		
	}
	//String name, int red, int green, int blue

	abstract void bite();

}