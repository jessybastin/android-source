package com.bloc.objects;

class Ensemble extends Object {
	// Name
	String mName;

	// All of the artists in the group
	Artist[] mArtists;

	/*
	 * Ensemble
	 *
	 * This constructor takes in a variable length of Artist objects
	 *
	 * @param artists variable length artists (Artist... artists)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the first Ensemble constructor
	/************************************************/

	public Ensemble(Artist[] mArtists) {
		super();
		this.mArtists = mArtists;
		//Check with John
		this.mName = mArtists[0].mFirstName+mArtists[0].mLastName;
	}
	
	/*
	 * Ensemble
	 *
	 * This constructor takes a name and a variable length of Artist objects
	 * Side-effect: if the 'name' parameter is null, uses the first and
	 * 				last name of the first Artist
	 * Hint:		You can add Strings together with a '+'
	 *
	 * @param name the name of the group (String)
	 * @param artists variable length artists (Artist... artists)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the second Ensemble constructor
	/************************************************/
	
	public Ensemble(String mName,Artist[] mArtists){
		super();
		this.mArtists =mArtists;
		if (mName == null){
			this.mName = mArtists[0].mFirstName+mArtists[0].mLastName;
		}
		else{
		
			this.mName = mName;
		}
		}
	
	}