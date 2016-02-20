package io.egen.rentalflix;


/**
 * Entity representing a movie. Fields: id, title, year, language
 */

public class Movie {

	private int id;
	private String title;
	private int year;
	private String language;
	private boolean isRented;

	public Movie(int id, String title, int year, String language,
			boolean isRented) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.language = language;
		this.isRented = isRented;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

}
