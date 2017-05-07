package text.popularity.provider;

import java.util.SortedMap;
import java.util.TreeMap;

import popularity.spi.TextPopularity;

public class TextPopularityProvider implements TextPopularity{
	private SortedMap<String, TextFeedBackMetrics>feedBackMetrics;
	private SortedMap<String, TextMetadataMetrics> metadataMetrics;
	private SortedMap<String, TextAuthorMetrics> authorMetrics;
	
	//Constructor without parameter
	public TextPopularityProvider (){
		feedBackMetrics= new TreeMap <String, TextFeedBackMetrics>();
		 metadataMetrics= new TreeMap <String, TextMetadataMetrics>();
		 authorMetrics= new TreeMap <String, TextAuthorMetrics>();
	}
	@Override
	public TextFeedBackMetrics getTextFeedBackMetada(String url) {
		
		return feedBackMetrics.get(url);
	}

	@Override
	public TextMetadataMetrics getTextMetadaMetrics(String url) {
		
		return metadataMetrics.get(url);
	}

	@Override
	public TextAuthorMetrics getTextAuthorMetrics(String url) {
		
		return authorMetrics.get(url);
	}

}
