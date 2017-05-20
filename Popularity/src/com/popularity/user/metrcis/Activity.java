package com.popularity.user.metrcis;

public class Activity {
	
private String  name; 
private int numberOf;





public Activity(String name, int numberOf) {
	super();
	this.name = name;
	this.numberOf = numberOf;
}






public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public int getNumberOf() {
	return numberOf;
}



public void setNumberOf(int numberOf) {
	this.numberOf = numberOf;
}






@Override
public String toString() {
	return "Activity [name=" + name + ", numberOf=" + numberOf + "]";
}





}
