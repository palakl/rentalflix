package io.egen.rentalflix;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {

	MovieService movieService = MovieService.getInstance();

	@Test
	public void findAll() {

		Assert.assertNotNull(movieService.findAll());
	}

	@Test
	public void findByName() {

		Assert.assertNotNull(movieService.findByName("Aven"));
	}

	@Test
	public void create() {

		Movie movie = new Movie(5, "Spider Man", 2015, "English", false);
		int size = movieService.findAll().size();
		movieService.create(movie);
		Assert.assertEquals(size + 1, movieService.findAll().size());
	}

	@Test
	public void update() {

		Movie movie = new Movie(5, "Spider Man", 2014, "English", true);
		Movie temp = movieService.update(movie);
		Assert.assertEquals(movie.getYear(), temp.getYear());
	}

	@Test
	public void delete() {

		int size = movieService.findAll().size();
		movieService.delete(2);
		Assert.assertEquals(size - 1, movieService.findAll().size());
	}

	@Test
	public void rentMovie() {

		Assert.assertTrue(movieService.rentMovie(4, "Test"));
	}

}
