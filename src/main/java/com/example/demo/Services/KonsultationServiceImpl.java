package com.example.demo.Services;

import com.example.demo.Models.Konsultation;
import com.example.demo.Repositories.KonsultationRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class KonsultationServiceImpl implements KonsultationService {

    @Autowired
    KonsultationRepositorySQL konsultationRepositorySQL;


    @Override
    public void opretKonsultation(Konsultation konsultation) throws SQLException, ClassNotFoundException {
                konsultationRepositorySQL.insertKonsultationToDB(
                konsultation.getBeskrivelse(),
                konsultation.getKonklusion(),
                konsultation.getDato());

    }


}
