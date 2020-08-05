package com.berga.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.berga.model.superheromovies.Movie;

public class MovieRepository {

	private EntityManager entityManager;

	public MovieRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<Movie> save(Movie movie) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(movie);
			entityManager.getTransaction().commit();
			return Optional.of(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public Optional<Movie> findById(Integer id) {
		Movie movieFound = entityManager.find(Movie.class, id);
		return movieFound != null ? Optional.of(movieFound) : Optional.empty();
	}

	public List<Movie> findAll() {
		return entityManager.createQuery("from Movies").getResultList();
	}

	public void deleteById(Integer id) {
		// Retrieve a movie with its id
		// Start a transaction
		// Removes all references to this movie by Super Heroes
		// Remove the movie
		// Commit the transaction
	}
}
