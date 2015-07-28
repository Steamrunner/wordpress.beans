package be.devoegt.koen.wordpress.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.LocalDateTime;
//
//import com.fasterxml.jackson.annotation.JsonProperty;

public class Media extends Post {

	private static final long serialVersionUID = -7183062277504305273L;
	
	private String source;
	@JsonProperty("is_image")
	private boolean image;
//	private ATTACHMENT_META

	public String getSource() {
		return source;
	}
	
}
