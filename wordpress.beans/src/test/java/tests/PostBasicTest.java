package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.ZoneOffset;

import org.junit.Test;

import be.devoegt.koen.wordpress.beans.Post;

public class PostBasicTest {

	private Post post = new Post();
	
	// TODO check all classes that have getters and setters?
	
	// set/getLink tests
	@Test
	public void setLink_DummyText_ReturnsNull() {
		post.setLink("dummy");
		assertNull(post.getLink());
	}

	@Test
	public void setLink_EmptyText_ReturnsNull() {
		post.setLink("");
		assertNull(post.getLink());
	}
	
	// set/getGuid tests
	@Test
	public void setGuid_DummyText_ReturnsNull() {
		post.setGuid("dummy");
		assertNull(post.getGuid());
	}

	@Test
	public void setGuid_EmptyText_ReturnsNull() {
		post.setGuid("");
		assertNull(post.getGuid());
	}
	
	// set/getDate tests
	@Test
	public void setDate_DummyText_ReturnsNull() {
		post.setDate("dummy");
		assertNull(post.getDate());
	}
	
	@Test
	public void setDate_EmptyText_ReturnsNull() {
		post.setDate("");
		assertNull(post.getDate());
	}
	
	@Test
	public void setDate_LocalDateString_ReturnsNull() {
		post.setDate("2000-01-01T23:59:59");
		assertEquals(post.getDate().toString(), "2000-01-01T23:59:59Z");
	}
	
	@Test
	public void setDate_ZonedDateString_ReturnsNull() {
		post.setDate("2000-01-01T23:59:59+00:00");
		assertEquals(post.getDate().toString(), "2000-01-01T23:59:59Z");
	}
	
	// get/setDate_tz tests
	@Test
	public void getDate_tz_DummyText_ReturnsNull() {
		post.setDate("dummy");
		assertNull(post.getDate_tz());
	}
	
	@Test
	public void getDate_tz_EmptyText_ReturnsNull() {
		post.setDate("");
		assertNull(post.getDate_tz());
	}
	
	@Test
	public void getDate_tz_LocalDateString_ReturnsValue() {
		post.setDate("2000-01-01T23:59:59");
		assertEquals(ZoneOffset.UTC,  post.getDate_tz());
	}
	
	@Test
	public void getDate_tz_ZonedDateString_ReturnsValue() {
		post.setDate("2000-01-01T23:59:59+00:00");
		assertEquals(ZoneOffset.UTC,  post.getDate_tz());
	}
	
	// set/getModified tests
	@Test
	public void setModified_DummyText_ReturnsNull() {
		post.setModified("dummy");
		assertNull(post.getModified());
	}
	
	@Test
	public void setModified_EmptyText_ReturnsNull() {
		post.setDate("");
		assertNull(post.getModified());
	}
	
	@Test
	public void setModified_LocalDateString_ReturnsNull() {
		post.setModified("2000-01-01T23:59:59");
		assertEquals(post.getModified().toString(), "2000-01-01T23:59:59Z");
	}
	
	@Test
	public void setModified_ZonedDateString_ReturnsNull() {
		post.setModified("2000-01-01T23:59:59+00:00");
		assertEquals(post.getModified().toString(), "2000-01-01T23:59:59Z");
	}
	
	// get/setModified_tz tests
	@Test
	public void getModified_tz_DummyText_ReturnsNull() {
		post.setModified("dummy");
		assertNull(post.getModified_tz());
	}
	
	@Test
	public void getModified_tz_EmptyText_ReturnsNull() {
		post.setModified("");
		assertNull(post.getModified_tz());
	}
	
	@Test
	public void getModified_tz_LocalDateString_ReturnsValue() {
		post.setModified("2000-01-01T23:59:59");
		assertEquals(ZoneOffset.UTC,  post.getModified_tz());
	}
	
	@Test
	public void getModified_tz_ZonedDateString_ReturnsValue() {
		post.setModified("2000-01-01T23:59:59+00:00");
		assertEquals(ZoneOffset.UTC,  post.getModified_tz());
	}
}
