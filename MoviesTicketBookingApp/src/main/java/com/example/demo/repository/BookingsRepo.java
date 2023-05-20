package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Bookings;

public interface BookingsRepo extends JpaRepository<Bookings, Integer>{

}
