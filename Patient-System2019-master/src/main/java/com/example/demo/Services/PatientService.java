package com.example.demo.Services;

import com.example.demo.Models.Patient;
import org.springframework.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    List<Patient> findAllePatienter();
    Patient findViaCPR(int cpr);
    void insert(Patient patient);

}