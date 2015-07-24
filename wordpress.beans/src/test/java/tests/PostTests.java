package tests;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import be.devoegt.koen.wordpress.beans.Post;

public class PostTests {

	private Post post; 
	
	@Before
	public void setUp() {
		 post = new Post();
	}

	@Test(expected = MalformedURLException.class)
	public void setLink_MalformedURLException() throws MalformedURLException {
		post.setLink("dummy");
	}

	@Test(expected = MalformedURLException.class)
	public void setGuid_MalformedURLException() throws MalformedURLException {
		post.setGuid("dummy");
	}
	
}
