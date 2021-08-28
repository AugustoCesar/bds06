package com.devsuperior.movieflix.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Transactional(readOnly = true)
	public Page<MovieCardDTO> findAllPaged(Long genreId, Pageable pageable) {

		List<Genre> genres = (genreId == 0) ? null : Arrays.asList(genreRepository.getOne(genreId));
		Page<Movie> page = movieRepository.find(genres, pageable);
		return page.map(x -> new MovieCardDTO(x));
	}

	@Transactional(readOnly = true)
	public MovieDetailsDTO findById(Long id) {
		Optional<Movie> obj = movieRepository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDetailsDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<ReviewDTO> findReviewsByMovieId(Long movieId) {

		Optional<Movie> obj = movieRepository.findById(movieId);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		List<Review> list = entity.getReviews();

		List<ReviewDTO> listDto = new ArrayList<>();
		for (Review review : list) {
			listDto.add(new ReviewDTO(review));
		}
		return listDto;
	}
}
