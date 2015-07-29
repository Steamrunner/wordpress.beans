package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.net.MalformedURLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.web.client.RestTemplate;

import be.devoegt.koen.wordpress.beans.Post;

@RunWith(Parameterized.class)
public class PostParseTest {

	private static Post post;

	// TODO set up dedicated test server

	@Parameters
	public static Collection<Object[]> setUpParameters() {

		Post v1Post, v2Post, v11WPComPost = new Post();
		Collection<Object[]> parameters = new ArrayList<Object[]>();
		
		RestTemplate v1RestTemplate = new RestTemplate();
		RestTemplate v2RestTemplate = new RestTemplate();
		RestTemplate v3RestTemplate = new RestTemplate();
		try {
		v1Post = v1RestTemplate.getForObject(
				"http://piratetimes.net/wp-json/posts/33933", Post.class);
		parameters.add(new Object[]{ v1Post });
		v2Post = v2RestTemplate.getForObject(
				"http://koen.devoegt.be/wp-json/posts/31", Post.class);
		parameters.add(new Object[]{ v2Post });
		v11WPComPost = v3RestTemplate.getForObject("https://public-api.wordpress.com/rest/v1.1/sites/wpapitest.wordpress.com/posts/1", Post.class);
		parameters.add(new Object[]{ v11WPComPost });
		} catch (Exception e) {
			System.out.println("Exception");
		}

		return parameters;//Arrays.asList(new Object[][] { { v2Post }, { v1Post }, { v11WPComPost } });

	}

	public PostParseTest(Post post) {
		PostParseTest.post = post;
	}

	@Test
	public void getDate_tz_returnsValue() {
		assertEquals(ZoneId.of("Europe/Brussels"), post.getDate_tz());
	}

	@Test
	public void getModified_tz_returnsValue() {
		assertEquals(ZoneId.of("Europe/Brussels"), post.getModified_tz());
	}

	@Test
	public void getID_returnsValue() {
		assertEquals(31, post.getID());
	}

	@Test
	public void getAuthor_getUsername_returnsValue() {
		assertEquals("Collentine", post.getAuthor().getUsername());
		// TODO only test if author is present test everything else in
		// AuthorTest
	}

	@Test
	public void getFeaturedImage_getID_returnsValue() {
		assertEquals(33938, post.getFeaturedImage().getID());
	}

	@Test
	public void getFeaturedImage_getSource_returnsValue() {
		assertEquals(
				"http://piratetimes.net/wp-uploads/news/2015/07/first-council-meeting-ppeu.jpg",
				post.getFeaturedImage().getSource());
	}
	
}
