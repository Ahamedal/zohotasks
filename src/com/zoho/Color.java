package com.zoho;


public enum Color {
	VIOLET,INDIGO,BLUE,GREEN,YELLOW,ORANGE,RED;
	 
	public int getCode() {
	   int position=ordinal()+1;
	   return position;
	}

}
