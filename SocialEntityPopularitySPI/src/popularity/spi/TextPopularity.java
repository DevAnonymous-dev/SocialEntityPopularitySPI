package popularity.spi;

import text.popularity.provider.TextAuthorMetrics;
import text.popularity.provider.TextFeedBackMetrics;
import text.popularity.provider.TextMetadataMetrics;


public interface TextPopularity {

	public TextFeedBackMetrics getTextFeedBackMetada( String url) ;
	public TextMetadataMetrics getTextMetadaMetrics( String url) ;
	public TextAuthorMetrics getTextAuthorMetrics(String url);
	
	
}
