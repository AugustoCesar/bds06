package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		User user = authService.authenticated();
		
		try {
			Review entity = new Review();
			entity.setMovie(movieRepository.getOne(dto.getMovieId()));
			entity.setText(dto.getText());
			entity.setUser(user);		
			
			entity = reviewRepository.save(entity);
			return new ReviewDTO(entity);
			
		} catch (ForbiddenException e) {
			throw new ForbiddenException("Acesso negado para o usuário: "+ user.getEmail());
		}
	}
	
}
