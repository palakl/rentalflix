package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Service implementing IFlix interface You can use any Java collection type to
 * store movies
 */
public class MovieService implements IFlix {

	List<Movie> movies;
	private static MovieService service = null;

	private MovieService() {

		movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "Avengers", 2015, "English", false));
		movies.add(new Movie(2, "Batman", 2014, "English", false));
		movies.add(new Movie(3, "Superman", 2013, "English", true));
		movies.add(new Movie(4, "X-men", 2012, "English", false));
	}

	public static synchronized MovieService getInstance() {
		if (service == null) {
			service = new MovieService();
		}
		return service;
	}

	@Override
	public List<Movie> findAll() {

		return movies;
	}

	@Override
	public List<Movie> findByName(String name) {

		List<Movie> result = null;

		Iterator<Movie> iterator = movies.iterator();
		while (iterator.hasNext()) {

			Movie movie = iterator.next();
			if (movie.getTitle().contains(name)) {

				result = new ArrayList<Movie>();
				result.add(movie);

			}
		}

		return result;
	}

	@Override
	public Movie create(Movie movie) {

		movies.add(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {

		boolean valid = false;
		Iterator<Movie> iterator = movies.iterator();
		while (iterator.hasNext()) {

			Movie temp = iterator.next();
			if (temp.getId() == movie.getId()) {

				temp.setLanguage(movie.getLanguage());
				temp.setTitle(movie.getTitle());
				temp.setYear(movie.getYear());
				valid = true;
			}
		}

		if (valid)
			return movie;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public Movie delete(int id) {

		Movie temp = null;
		boolean valid = false;
		Iterator<Movie> iterator = movies.iterator();
		while (iterator.hasNext()) {

			Movie movie = iterator.next();
			if (movie.getId() == id) {
				iterator.remove();
				valid = true;
			}
		}
		if (valid)
			return temp;
		else
			throw new IllegalArgumentException("Movie not found");
	}

	@Override
	public boolean rentMovie(int movieId, String user) {

		Iterator<Movie> iterator = movies.iterator();
		while (iterator.hasNext()) {

			Movie movie = iterator.next();
			if (movie.getId() == movieId) {

				if (!movie.isRented()) {
					return true;
				} else {

					throw new IllegalArgumentException("Movie not found");
				}

			}
		}
		return false;
	}

}
