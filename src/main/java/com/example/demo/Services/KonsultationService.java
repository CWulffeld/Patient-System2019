package com.example.demo.Services;
import com.example.demo.Models.*;

import java.sql.SQLException;

public interface KonsultationService {
    void opretKonsultation(Konsultation konsultation) throws SQLException, ClassNotFoundException;
}
