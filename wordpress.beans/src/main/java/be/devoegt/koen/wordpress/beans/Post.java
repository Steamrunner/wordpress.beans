package be.devoegt.koen.wordpress.beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Post implements Serializable, Comparable<Post> {

	private static final long serialVersionUID = -467706187698544476L;

	// Overlapping

	private boolean sticky;
	@JsonProperty("ID")
	private int ID;
	@JsonProperty("menu_order")
	private int menu_order;
	private String title, status, type, content, parent, format, slug, excerpt,
			comment_status, ping_status;
	private URL link, guid;
	private LocalDateTime date_gmt, modified_gmt;
	private ZonedDateTime date, modified;
	private ZoneId date_tz, modified_tz;
	private Author author;
	private Media featured_image;

	// v1 specific

	// meta
	// terms

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getMenu_order() {
		return menu_order;
	}
	
	public String getTitle() {
		return title;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public String getParent() {
		return parent;
	}

	public String getFormat() {
		return format;
	}

	public String getSlug() {
		return slug;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public String getComment_status() {
		return comment_status;
	}

	public String getPing_status() {
		return ping_status;
	}

	public boolean isSticky() {
		return sticky;
	}

	public URL getLink() {
		return link;
	}

	public void setLink(String linkString) {
		try {
			link = new URL(linkString);
		} catch (MalformedURLException e) {
			link = null;
		}
	}

	public URL getGuid() {
		return guid;
	}

	public void setGuid(String guidString) {
		try {
			guid = new URL(guidString);
		} catch (MalformedURLException e) {
			guid = null;
		}
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(String dateString) {
		date = getDate(dateString);
		if (date != null)
			date_tz = date.getZone();
	}

	public ZonedDateTime getModified() {
		return modified;
	}

	public void setModified(String dateString) {
		modified = getDate(dateString);
		if (modified != null)
			modified_tz = date.getZone();
	}

	public LocalDateTime getDate_gmt() {
		return date_gmt;
	}

	public void setDate_gmt(String date_gmtString) {
		this.date_gmt = LocalDateTime.parse(date_gmtString);
	}

	public LocalDateTime getModified_gmt() {
		return modified_gmt;
	}

	public void setModified_gmt(String modified_gmtString) {
		this.modified_gmt = LocalDateTime.parse(modified_gmtString);
	}

	public Author getAuthor() {
		return author;
	}
	
	public Media getFeatured_image() {
		return featured_image;
	}
	
	public void setFeatured_image(Object o) {
		featured_image = null;
	} 

	public ZoneId getDate_tz() {
		return date_tz;
	}

	public void setDate_tz(String date_tz) {
		this.date_tz = ZoneId.of(date_tz);
	}

	public ZoneId getModified_tz() {
		return modified_tz;
	}

	public void setModified_tz(String modified_tz) {
		this.modified_tz = ZoneId.of(modified_tz);
	}

	public int compareTo(Post post) {
		// TODO Auto-generated method stub
		// based on modified date
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (ID != other.ID)
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		return true;
	}

	private ZonedDateTime getDate(String dateString) {
		try {
			date = ZonedDateTime.parse(dateString);
		} catch (DateTimeParseException e) {
			try {
				dateString = dateString + "+00:00";
				date = ZonedDateTime.parse(dateString);
			} catch (DateTimeParseException ex) {
				date = null;
			}
		}
		return date;
	}

}
