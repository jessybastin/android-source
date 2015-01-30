package com.bloc.inherit;

/************************************************
 *	ASSIGNMENT:
 *	Define the GoldenRetriever class below
 *
 *	Golden Retrievers shrink to a smaller size after
 *	playing only 3 times.
/************************************************/

public class GoldenRetriever extends Dog{
/*
 * play
 * Side-effect: 1. The Dog loses weight
 *				2. Every 6 play invocations, the Dog shrinks to a smaller size, if possible
 *				i.e. "large" -> "average" -> "small" -> "tiny"
 * @return nothing
 */
void play() {

	// Pre-increment play counter
	if (++mPlayCounter == 3) {
		changeSize(false);
		mPlayCounter = 0;
	}
}
}

