package be.devoegt.koen.wordpress.beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Post implements Serializable, Comparable<Post> {

	private static final long serialVersionUID = -467706187698544476L;

	private boolean sticky;
	@JsonProperty("ID")
	private int ID;
	@JsonProperty("menu_order")
	private int menu_order;
	private String title, status, type, content, parent, format, slug, excerpt,
			comment_status, ping_status;
	private URL link, guid;
	private LocalDateTime date, modified, date_gmt, modified_gmt;
	private Author author;
	@JsonProperty("featured_image")
	private Media featuredImage;

	// date_tz
	// modified_tz

	// meta
	// terms

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
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

	public int getMenu_order() {
		return menu_order;
	}

	public boolean isSticky() {
		return sticky;
	}

	public URL getLink() {
		return link;
	}

	public void setLink(String linkString) throws MalformedURLException {
		link = new URL(linkString);
	}

	public URL getGuid() {
		return guid;
	}

	public void setGuid(String guidString) throws MalformedURLException {
		guid = new URL(guidString);
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(String dateString) {
		this.date = LocalDateTime.parse(dateString);
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(String dateString) {
		this.modified = LocalDateTime.parse(dateString);
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

	public Media getFeaturedImage() {
		return featuredImage;
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

}
