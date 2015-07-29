package tests;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

import be.devoegt.koen.wordpress.beans.Post;

public class PostBasicTest {

	private Post post = new Post();
	
	@Test(expected = MalformedURLException.class)
	public void setLink_DummyText_MalformedURLException() throws MalformedURLException {
		post.setLink("dummy");
	}

	@Test(expected = MalformedURLException.class)
	public void setGuid_DummyText_MalformedURLException() throws MalformedURLException {
		post.setGuid("dummy");
	}

	@Test
	public void setLink_EmptyText_MalformedURLException() throws MalformedURLException {
		post.setLink("");
		assertNull(post.getLink());
	}

	@Test
	public void setGuid_EmptyText_ReturnsNull() throws MalformedURLException {
		post.setGuid("");
		assertNull(post.getGuid());
	}
}
