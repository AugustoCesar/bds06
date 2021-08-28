package com.devsuperior.movieflix.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;

	@Transactional(readOnly = true)
	public List<GenreDTO> findAllPaged() {
		List<Genre> listEntity = genreRepository.findAll();
		List<GenreDTO> listDto = new ArrayList<>();
		for (Genre genre : listEntity) {
			listDto.add(new GenreDTO(genre));
		}
		return listDto;
	}
}
