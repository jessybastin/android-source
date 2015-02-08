package com.bloc.securitypackages.citrus;

import com.bloc.securitypackages.Fruit;
import com.bloc.securitypackages.colors.OrangeRed;

/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

class Grapefruit extends Fruit {
	public Grapefruit() {
		super(Grapefruit.class.getSimpleName(), 210, new OrangeRed(), .48d);
	}
}