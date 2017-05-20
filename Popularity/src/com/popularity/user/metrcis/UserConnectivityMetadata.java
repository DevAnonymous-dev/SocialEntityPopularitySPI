package com.popularity.user.metrcis;

import java.util.ArrayList;

public class UserConnectivityMetadata {
	

private	 ArrayList<Connectivity> connectivity;


public UserConnectivityMetadata(ArrayList<Connectivity> connectivity) {
	super();
	this.connectivity = connectivity;
}


public ArrayList<Connectivity> getConnectivity() {
	return connectivity;
}


public void setConnectivity(ArrayList<Connectivity> connectivity) {
	this.connectivity = connectivity;
}


@Override
public String toString() {
	return "UserConnectivityMetadata [connectivity=" + connectivity + "]";
}



	

}