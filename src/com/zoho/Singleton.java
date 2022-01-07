package com.zoho;



public class Singleton {
		private static Singleton singleton;
		private Singleton(){
			
		}
		public static Singleton getObject() {
			if(singleton==null) {
				synchronized(Singleton.class) {
			if(singleton==null) {
				singleton=new Singleton();
			}
			}
			}
			return singleton;
		}
		public void display() {
			System.out.println("using singleton pattern");
		}
}


