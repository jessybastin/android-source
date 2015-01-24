package com.bloc.bestpractices;


public class WorstPractices extends Object {

	/************************************************
	 *	ASSIGNMENT:
	 *	Fix code and comments below this block
	/************************************************/

	public static void main(String [] args) {
		int magicNumber = WorstPractices.animals(false);
		magicNumber *= 5;
		System.out.println("Magic Number from animals method  "+magicNumber);
		if (magicNumber > 18) {
			while(magicNumber > 0){
				magicNumber--;
			}
		}
	}

/*
this method takes in a single parameter, animalExists. 
Using a very elaborate and complex algorithm, it calculate a magic number
*/

private static int animals(boolean animalExists){

	//If animalExists is true, then the value returned if 34 else 21.
	int aInt = animalExists ? 34 : 21;
	float sparklesfairy = .5f;
	for (int brown = 0; brown < aInt; brown++) { 
		sparklesfairy *= aInt;
		System.out.println("sparklesfairy "+sparklesfairy);
	} 
	return (int) sparklesfairy * aInt;
}

	/************************************************
	 *	ASSIGNMENT
	 *	Fix code and comments above this block
	/************************************************/
}
