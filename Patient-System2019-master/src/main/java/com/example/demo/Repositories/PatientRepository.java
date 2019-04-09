package com.example.demo.Repositories;

import com.example.demo.Models.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository
{
    List<Patient> SorterViaCPR();

    List<Patient> SorterViaNavn();

    List<Patient> SorterViaAlder();

    List<Patient> SorterViaHøjde();

    List<Patient> SorterViaVægt();
}
