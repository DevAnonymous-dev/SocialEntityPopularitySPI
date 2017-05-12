package popularity.media.metrics;


public class TextMetadataMetrics extends  MediaMetadataMetrics{
private String text ;

public TextMetadataMetrics(String id, String url, String ceratedAt, String text) {
	super(id, url, ceratedAt);
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
