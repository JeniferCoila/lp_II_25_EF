package com.cb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cb.model.TblMedico;
import com.cb.service.IMedicoService;

@Controller  
@RequestMapping("/views")
public class MedicoController {
    
    @Autowired
    private IMedicoService doctorService;
    
    @GetMapping("/doctorList")
    public String listDoctors(@RequestParam(name = "name", required = false) String firstName, Model model) {
        List<TblMedico> doctorList;

        if (firstName != null && !firstName.isEmpty()) {
            doctorList = doctorService.findDoctorsByName(firstName);
        } else {
            doctorList = doctorService.getAllDoctors();  
        }

        model.addAttribute("doctorList", doctorList);
        model.addAttribute("name", firstName); 
        return "views/list";  
    }
    
    @GetMapping("/registerDoctor")
    public String registerDoctor(Model model) {
        TblMedico doctor = new TblMedico();
        model.addAttribute("medico", doctor);
        return "views/modify";  
    }
    
    @PostMapping("/saveDoctor")
    public String saveDoctor(@ModelAttribute TblMedico medico, RedirectAttributes redirectAttributes) {
        try {
            doctorService.registerDoctor(medico);  
            redirectAttributes.addFlashAttribute("message", "Médico registrado exitosamente.");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error al registrar el médico.");
            redirectAttributes.addFlashAttribute("messageType", "danger");
        }
        return "redirect:/views/doctorList";
    }
    
    @GetMapping("/editDoctor/{id}")
    public String editDoctor(@PathVariable("id") Integer doctorId, Model model) {
        TblMedico doctor = doctorService.getDoctorById(doctorId);
        model.addAttribute("medico", doctor);
        return "views/modify";  
    }
    
    @GetMapping("/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable("id") Integer doctorId, RedirectAttributes redirectAttributes) {
        try {
            doctorService.deleteDoctor(doctorId);  
            redirectAttributes.addFlashAttribute("message", "Médico eliminado correctamente.");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error al eliminar el médico.");
            redirectAttributes.addFlashAttribute("messageType", "danger");
        }
        return "redirect:/views/doctorList";      
    }
}