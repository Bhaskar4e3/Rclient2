package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Pupil;
@Repository
public interface PupilRepo extends JpaRepository<Pupil, Integer> {
	@Query(value = "select * from students where student_id=:id",nativeQuery = true)
	public Pupil getByid(int id) ;
}
