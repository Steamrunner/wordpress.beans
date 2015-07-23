package be.devoegt.koen.wordpress.beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author implements Serializable {

	private static final long serialVersionUID = 4697024215610736344L;

	@JsonProperty("ID")
	private Integer ID;
	private String username, name, first_name, last_name, nickname, slug,
			description;
	@JsonProperty("URL")
	private URL url;
	private URL avatar;
	private ZonedDateTime registered;

	// TODO support meta

	public Integer getID() {
		return ID;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getNickname() {
		return nickname;
	}

	public String getSlug() {
		return slug;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(String urlString) throws MalformedURLException {
		if (urlString.isEmpty()) url = null;
		else url = new URL(urlString);
	}

	public URL getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatarString) throws MalformedURLException {
		if (avatarString.isEmpty()) avatar = null;
		else avatar = new URL(avatarString);
	}

	public String getDescription() {
		return description;
	}

	public ZonedDateTime getRegistered() {
		return registered;
	}

	public void setRegistered(String dateRegistered) {
		this.registered = ZonedDateTime.parse(dateRegistered);
	}

}
