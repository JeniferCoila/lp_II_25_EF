package com.cb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cb.model.TblMedico;
import com.cb.repository.IMedicoRepository;

@Service
public class MedicoServiceImp implements IMedicoService {
    
    @Autowired
    private IMedicoRepository medicoRepository;

    @Override
    public void registerDoctor(TblMedico doctor) {
        medicoRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Integer id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public List<TblMedico> getAllDoctors() {
        return (List<TblMedico>) medicoRepository.findAll();
    }

    @Override
    public TblMedico getDoctorById(Integer id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public List<TblMedico> findDoctorsByName(String name) {
        return medicoRepository.findByFirstNameContainingIgnoreCase(name);
    }
}
