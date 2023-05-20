package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bookings;
import com.example.demo.repository.BookingsRepo;

//shows data on browser
@RestController
public class BookingsCtrl {
	@Autowired
	BookingsRepo bookingsRepo;
	@GetMapping("/bookings")
	public List<Bookings> getAllBookings(){
		return bookingsRepo.findAll();
				
	}
	@GetMapping("/bookings/{id}")
	public Bookings getBookingsByid(@PathVariable("id")int id) {
		return bookingsRepo.findById(id).get();
	}
	@PostMapping("/bookings")
	public String addMovie(@RequestBody Bookings bookings)
	{
		bookingsRepo.save(bookings);
		return "Object is saved!";
	}
	
	@PutMapping("/bookings/{id}")
	public String updateBookings(@RequestBody Bookings bookings) {
		Bookings bookings1 = (Bookings)bookingsRepo.findById(bookings.getBooking_id()).get();
				if(bookings1.getBooking_id()==bookings.getBooking_id()) {
					bookings1.setBooking_id(bookings.getBooking_id());
					bookings1.setShow_id(bookings.getShow_id());
					bookings1.setBooking_date(bookings.getBooking_date());
					bookings1.setTotal_amount(bookings.getTotal_amount());
					bookingsRepo.save(bookings1);
					

}
				return "record updated";
	}
				@DeleteMapping("/bookings/{id}")
				public String deleteBookingsById(@PathVariable("id")int id) {
					Bookings bookings1 = bookingsRepo.findById(id).get();
					if(bookings1.getBooking_id()==id) {
						bookingsRepo.delete(bookings1);
						
					}
					return "Record Deleted!";
				}
}
				
