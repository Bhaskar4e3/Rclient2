 package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Pupil;
import com.example.repository.PupilRepo;

@RestController
@RequestMapping("/students/")
public class HomeController {
	@Autowired
	private PupilRepo pupilRepo;
	

	public PupilRepo getPupilRepo() {
		return pupilRepo;
	}


	public void setPupilRepo(PupilRepo pupilRepo) {
		this.pupilRepo = pupilRepo;
	}

    @GetMapping("/{id}")
	public Pupil getOne(@PathVariable int id) {
    	Pupil pupil=null;
    	
		 pupil=pupilRepo.getByid(id);
		 if(pupil==null) {
			 //return "id is not available in database";
			 Pupil pupil1 =new Pupil();
			 pupil1.setStudent_id(0);
			 pupil1.setStudent_name("not available in DB");
			 pupil1.setStudent_address("not available in DB");
			 pupil1.setStudent_contact("not available in DB");
			 return pupil1;
		 }
    
    
		return pupil;
		
	}
    @GetMapping("/")
  	public List<Pupil> getall() {
  		List<Pupil> pupil=pupilRepo.findAll();
  		
  		return pupil;}
  		
  	
@PostMapping("/")
	public Pupil add(@RequestBody Pupil pupil) {
		Pupil pupils=pupilRepo.save(pupil);
		
		return pupils;}
		
	@PutMapping("/{id}")
       public Pupil update(@PathVariable int id, @RequestBody Pupil pupil) {
		Pupil p=pupilRepo.getByid(id);
		p.setStudent_address(pupil.getStudent_address());
		p.setStudent_contact(pupil.getStudent_contact());
		Pupil pupilu=pupilRepo.save(p);
		return pupilu;
    	   
       }
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
	Optional<Pupil> pupil=	Optional.ofNullable(pupilRepo.getByid(id));
	if(pupil.isPresent()) {
		pupilRepo.deleteById(id);
		return "done deleted";
	}
	else {
		
		return "delete not possible there is no such id in DB";
	}
	}


}