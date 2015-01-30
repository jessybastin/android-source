package com.bloc.inherit;

/************************************************
 *	ASSIGNMENT:
 *	Define the Chihuahua class below
 *
 *	Chiuahuas must be fed 5 times in order to grow
 *	larger.
/************************************************/

public class Chihuahua extends Dog{
	
	// Tracks how many times the dog has been fed
		int mFeedCounter;

	void feed() {
		// Pre-increment feed counter
		if (++mFeedCounter == 5) {
			changeSize(true);
			mFeedCounter = 0;
		}
	}
		
	}



