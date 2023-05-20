package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Movies;

public interface MoviesRepo extends JpaRepository<Movies, Integer>{

}
