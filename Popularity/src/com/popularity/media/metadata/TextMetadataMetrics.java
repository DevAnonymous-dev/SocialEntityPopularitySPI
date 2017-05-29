package com.popularity.media.metadata;

import java.util.Date;


public class TextMetadataMetrics extends  MediaMetadataMetrics{
private String text ;

public TextMetadataMetrics(String id, String url, Date createdAt, String text) {
	super(id, url, createdAt);
	
	this.text = text;
}


public TextMetadataMetrics( String url, Date createdAt, String text) {
	super(url, createdAt);
	this.text = text;
}




public String getText() {
	return text;
}




public void setText(String text) {
	this.text = text;
}



@Override
public String toString() {
	return "TextMetadataMetrics [text=" + text + "]";
}

	

}
