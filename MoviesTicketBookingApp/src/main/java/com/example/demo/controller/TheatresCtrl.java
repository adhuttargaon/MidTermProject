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

import com.example.demo.entity.Theatres;
import com.example.demo.repository.TheatresRepo;
//shows data on browser
@RestController
public class TheatresCtrl {
	@Autowired
	TheatresRepo theatresRepo;
	@GetMapping("/theatres")
	public List<Theatres> getAllTheatres(){
		return theatresRepo.findAll();
				
	}
	@GetMapping("/theatres/{id}")
	public Theatres getTheatresByid(@PathVariable("id")int id) {
		return theatresRepo.findById(id).get();
	}
	@PostMapping("/theatres")
	public String addTheatres(@RequestBody Theatres theatres)
	{
		theatresRepo.save(theatres);
		return "Object is saved!";
	}
	
	@PutMapping("/theatres/{id}")
	public String updateTheatres(@RequestBody Theatres theatres) {
		Theatres theatres1 = (Theatres)theatresRepo.findById(theatres.getTheatre_id()).get();
				if(theatres1.getTheatre_id()==theatres.getTheatre_id()) {
					theatres1.setTheatre_name(theatres.getTheatre_name());
					theatres1.setLocation(theatres.getLocation());
					theatres1.setSeating_capacity(theatres.getSeating_capacity());
					theatresRepo.save(theatres1);
					

}
				return "record updated";
	}
				@DeleteMapping("/theatres/{id}")
				public String deletetTheatresById(@PathVariable("id")int id) {
					Theatres theatres1 = theatresRepo.findById(id).get();
					if(theatres1.getTheatre_id()==id) {
						theatresRepo.delete(theatres1);
						
					}
					return "Record Deleted!";
				}
}
				
