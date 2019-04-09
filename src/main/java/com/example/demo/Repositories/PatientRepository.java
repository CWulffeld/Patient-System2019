package com.example.demo.Repositories;

import com.example.demo.Models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {



}



//package com.example.demo.Repositories;
//
//import com.example.demo.Models.Patient;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface PatientRepository extends CrudRepository<Patient, Integer>
//{
//}
