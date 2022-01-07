package com.zoho1;

import com.zoho.Color;
public class EnumRunner {
	public static void main(String[] args) {
		
		for(Color code:Color.values()) {
			System.out.println("color code of "+code+" is "+code.getCode());
		}
		//System.out.println(Color.VIOLET.getCode());
		Color c=Color.VIOLET;
		c.getCode();
}
}