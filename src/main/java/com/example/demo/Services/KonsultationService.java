package com.example.demo.Services;
import com.example.demo.Models.*;

import java.sql.SQLException;
import java.util.List;

public interface KonsultationService {


    void opretKonsultation(Konsultation konsultation) throws SQLException, ClassNotFoundException;

    List<Konsultation> findKonsultationerViaCpr(int cpr) throws SQLException, ClassNotFoundException;



}
