package com.popularity.user.metrcis;

public class Connectivity {
private ConnectivityType type;
private String name;
private int numberOf;




public Connectivity(ConnectivityType type, String name, int numberOf) {
	super();
	this.type = type;
	this.name = name;
	this.numberOf = numberOf;
}




public ConnectivityType getType() {
	return type;
}




public void setType(ConnectivityType type) {
	this.type = type;
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
	return "Connectivity [type=" + type + ", name=" + name + ", numberOf="
			+ numberOf + "]";
}



}
