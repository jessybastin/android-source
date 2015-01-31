package com.bloc.objects;

class Song extends Object {
	// The ensemble which produced it
	Ensemble mEnsemble;
	// Title of the song
	String mTitle;
	// The year it was released
	int mYearReleased;

	/*
	 * Song
	 *
	 * Default Constructor
	 * Side-effects: Assigns some default ensemble, title and
	 *				 and year of your choosing
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the first Song constructor
	/************************************************/
	
	public Song(){
		super();
		Artist[] artist = new Artist[2];
		for (int i=0; i< artist.length;i++){
			artist[0]= new Artist("Alexander","Wilson");
			artist[1]= new Artist("Johnson","William");
		}
		this.mEnsemble = new Ensemble(artist);
		this.mTitle  = "Title 1";
		this.mYearReleased = 1970;
	}
	/*
	 * Song
	 *
	 * Side-effects: Sets the year of release to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the second Song constructor
	/************************************************/
	public Song(Ensemble mEnsemble, String mTitle) {
		super();
		this.mEnsemble = mEnsemble;
		this.mTitle = mTitle;
		this.mYearReleased = 0;
	}
	
	
	/*
	 * Song
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the third Song constructor
	/************************************************/
	
	public Song(Ensemble mEnsemble, String mTitle, int mYearReleased) {
		super();
		this.mEnsemble = mEnsemble;
		this.mTitle = mTitle;
		this.mYearReleased = mYearReleased;
	}
	
}