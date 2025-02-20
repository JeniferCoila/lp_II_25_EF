package com.cb.service;

import java.util.List;
import com.cb.model.TblMedico;

public interface IMedicoService {
    
    void registerDoctor(TblMedico doctor);
    void deleteDoctor(Integer id);
    List<TblMedico> getAllDoctors();
    TblMedico getDoctorById(Integer id);
    List<TblMedico> findDoctorsByName(String firstName);
}