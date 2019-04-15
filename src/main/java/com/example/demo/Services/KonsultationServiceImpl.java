package com.example.demo.Services;

import com.example.demo.Models.Konsultation;
import com.example.demo.Repositories.KonsultationRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class KonsultationServiceImpl implements KonsultationService {

    @Autowired
    KonsultationRepositorySQL konsultationRepositorySQL;


    @Override
    public void opretKonsultation(Konsultation konsultation) throws SQLException, ClassNotFoundException {
                konsultationRepositorySQL.insertKonsultationToDB(konsultation.getPatientNavn(),
                        konsultation.getCpr(), konsultation.getBeskrivelse(),
                        konsultation.getKonklusion(), konsultation.getDato());
    }

    @Override
    public List<Konsultation> findKonsultationerViaCpr(int cpr) throws SQLException, ClassNotFoundException {
        List<Konsultation> konsultationer = konsultationRepositorySQL.FindPatientKonsultationData(cpr);
        return konsultationer;
    }


}
