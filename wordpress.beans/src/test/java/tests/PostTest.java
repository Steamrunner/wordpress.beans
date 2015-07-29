package tests;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.web.client.RestTemplate;

import be.devoegt.koen.wordpress.beans.Post;

@RunWith(Parameterized.class)
public class PostTest {

//	@Parameter
	private static String url;
	private static Post post;
	
	@BeforeClass
	public static void setUpClass() {
//		post = new Post();
//		RestTemplate restTemplate = new RestTemplate();
//		post = restTemplate.getForObject(
//				"http://piratetimes.net/wp-json/posts/33933", Post.class);
//		// TODO set up dedicated test server
	}

	@Parameters
	public static Collection<Object[]> setUpParameters() {
		
		Post v1Post, v2Post = new Post();
		RestTemplate v1RestTemplate = new RestTemplate();
		RestTemplate v2RestTemplate = new RestTemplate();
		v1Post = v1RestTemplate.getForObject(
				"http://piratetimes.net/wp-json/posts/33933", Post.class);
		v1Post = v2RestTemplate.getForObject(
				"http://koen.devoegt.be/wp-json/posts/31", Post.class);
		
		System.out.println("test");
		return Arrays.asList(new Object[][] { { v1Post }, { v2Post }});

//		return Arrays.asList(new Object[][] { { "http://piratetimes.net/wp-json/posts/33933" }, { "http://koen.devoegt.be/wp-json/posts/31" }});

	}
	
	  public PostTest(Post post) {
	        this.post = post;
	    	System.out.println(post);
	    }

//	@Before
//	public void setUpMethode() {
//	}

	@Test
	public void getDate_tz_returnsValue() {
		assertEquals(ZoneId.of("Europe/London"), post.getDate_tz());
	}

	@Test
	public void getModified_tz_returnsValue() {
		assertEquals(ZoneId.of("Europe/London"), post.getModified_tz());
	}

	@Test
	public void getID_returnsValue() {
		assertEquals(33933, post.getID());
	}

//	@Test
//	public void getAuthor_getUsername_returnsValue() {
//		assertEquals("Collentine", post.getAuthor().getUsername());
//		// TODO only test if author is present test everything else in
//		// AuthorTest
//	}
//
//	@Test
//	public void getFeaturedImage_getID_returnsValue() {
//		assertEquals(33938, post.getFeaturedImage().getID());
//	}
//
//	@Test
//	public void getFeaturedImage_getSource_returnsValue() {
//		assertEquals(
//				"http://piratetimes.net/wp-uploads/news/2015/07/first-council-meeting-ppeu.jpg",
//				post.getFeaturedImage().getSource());
//	}
//
//	@Test(expected = MalformedURLException.class)
//	public void setLink_MalformedURLException() throws MalformedURLException {
//		post.setLink("dummy");
//	}
//
//	@Test(expected = MalformedURLException.class)
//	public void setGuid_MalformedURLException() throws MalformedURLException {
//		post.setGuid("dummy");
//	}

}
