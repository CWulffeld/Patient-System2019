package com.example.demo.Services;

import com.example.demo.Models.Konsultation;
import com.example.demo.Repositories.KonsultationRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class KonsultationServiceImpl implements KonsultationService {

    @Autowired
    KonsultationRepositorySQL konsultationRepositorySQL;

    @Override
    public void opretKonsultation(Konsultation konsultation) throws SQLException, ClassNotFoundException {
        konsultationRepositorySQL.insertKonulstationtoDB(konsultation.getPatientFornavn(),
                konsultation.getPatientEfternavn(), konsultation.getCpr(), konsultation.getBeskrivelse(),
                konsultation.getKonklusion(), konsultation.getDato()
                );
    }
}
