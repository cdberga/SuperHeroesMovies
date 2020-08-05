package com.berga.model.superheromovies;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUPER_HEROES")
public class SuperHero {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "SUPERHEROES_MOVIES", joinColumns = { @JoinColumn(name = "superhero_id") }, inverseJoinColumns = {
			@JoinColumn(name = "movie_id") })
	private Set<Movie> movies = new HashSet<Movie>();

	public SuperHero() {
	}

	public SuperHero(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public SuperHero(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	@Override
	public String toString() {
		return "SuperHero{" + "id=" + id + ", name='" + name + '\'' + ", movies='"
				+ movies.stream().map(Movie::getTitle).collect(Collectors.toList()) + '\'' + '}';
	}
}
