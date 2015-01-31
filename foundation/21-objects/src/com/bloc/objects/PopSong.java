package com.bloc.objects;

class PopSong extends Song {
	// The number of weeks this song stayed on Billboard's top 100
	int mWeeksOnBillboard;

	/*
	 * PopSong
	 *
	 * Side-effects: Assigns some default ensemble, title,
	 *				 year and number of weeks on billboard
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the first PopSong constructor
	/************************************************/
     public PopSong(){
 		super();
 		Artist[] artist = new Artist[2];
 		for (int i=0; i< artist.length;i++){
 			artist[0]= new Artist("Alexander","Wilson PopSong");
 			artist[1]= new Artist("Johnson","William PopSong");
 		}
 		this.mEnsemble = new Ensemble(artist);
 		this.mTitle  = "Title PopSong 1";
 		this.mYearReleased = 1900;    	 
     }
	/*
	 * PopSong
	 * 
	 * Side-effects: Sets the year of release to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the second PopSong constructor
	/************************************************/

     public PopSong(Ensemble mEnsemble, String mTitle){
    	 super();
    	 this.mEnsemble = mEnsemble;
  		 this.mTitle  = mTitle;
     }
     
	/*
	 * PopSong
	 *
	 * Side-effects: Sets the weeks on billboard to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the third PopSong constructor
	/************************************************/
 	
     public PopSong(Ensemble mEnsemble, String mTitle, int mYearReleased) {
		super();
		this.mEnsemble = mEnsemble;
		this.mTitle = mTitle;
		this.mYearReleased = mYearReleased;
	}
     
	/*
	 * PopSong
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 * @param weeksOnBillboard number of weeks this song lasted on the
	 *		  				   Billboard's top 100 (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the fourth PopSong constructor
	/************************************************/
     
     public PopSong(Ensemble mEnsemble, String mTitle, int mYearReleased, int mWeeksOnBillboard) {
 		super();
 		this.mEnsemble = mEnsemble;
 		this.mTitle = mTitle;
 		this.mYearReleased = mYearReleased;
 		this.mWeeksOnBillboard = mWeeksOnBillboard;
 	}
}