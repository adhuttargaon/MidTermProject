package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Theatres;

public interface TheatresRepo extends JpaRepository<Theatres, Integer> {

}
