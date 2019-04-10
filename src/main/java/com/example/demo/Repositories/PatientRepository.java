package com.example.demo.Repositories;

import com.example.demo.Models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PatientRepository extends CrudRepository<Patient, Integer> {



}



