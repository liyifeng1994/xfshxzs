package com.soecode.xfshxzs.service;

import java.util.List;

import org.junit.Test;

import com.soecode.xfshxzs.po.movie.Movie;
import com.soecode.xfshxzs.po.movie.MovieCommentResult;
import com.soecode.xfshxzs.po.movie.MovieDetail;
import com.soecode.xfshxzs.po.movie.MovieStoryResult;
import com.soecode.xfshxzs.service.MovieService;

public class MovieServiceTest {

	MovieService movieService = new MovieService();

	@Test
	public void testGetMovieList() {
		List<Movie> list = movieService.getMovieList();
		for (Movie movie : list) {
			System.out.println(movie);
		}
	}

	@Test
	public void testGetMovieDetailById() {
		MovieDetail movieDetail = movieService.getMovieDetailById("89");
		System.out.println(movieDetail);
	}

	@Test
	public void testGetMovieURLById() {
		String url = movieService.getMovieURLById("89");
		System.out.println(url);
	}

	@Test
	public void teetGetFirstMovieStoryById() {
		MovieStoryResult storyResult = movieService.getMovieStoryById("first", "89");
		System.out.println(storyResult);
	}

	@Test
	public void teetGetAllMovieStoryById() {
		MovieStoryResult storyResult = movieService.getMovieStoryById("all", "89");
		System.out.println(storyResult);
	}

	@Test
	public void testGetPraiseMovieCommentById() {
		MovieCommentResult commentResult = movieService.getMovieCommentById("praise", "89");
		System.out.println(commentResult);
	}

	@Test
	public void testGetTimeMovieCommentById() {
		MovieCommentResult commentResult = movieService.getMovieCommentById("time", "89");
		System.out.println(commentResult);
	}

}
