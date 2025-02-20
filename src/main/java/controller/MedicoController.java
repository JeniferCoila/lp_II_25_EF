package controller;

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

import model.TblMedico;
import service.IMedicoService;

@Controller  
@RequestMapping("/views")
public class MedicoController {
    
    @Autowired
    private IMedicoService doctorService;
    
    @GetMapping("/doctorList")
    public String listdoctors(@RequestParam(name = "name", required = false) String name, Model model) {
        List<TblMedico> doctorList;

        if (name != null && !name.isEmpty()) {
            doctorList = doctorService.findDoctorsByName(name);
        } else {
            doctorList = doctorService.getAllDoctors();  
        }

        model.addAttribute("doctorList", doctorList);
        model.addAttribute("name", name); 
        return "views/list";  
    }
    
    @GetMapping("/registerDoctor")
    public String registerDoctor(Model model) {
        TblMedico TblMedico = new TblMedico();
        model.addAttribute("TblMedico", TblMedico);
        return "views/modify";  
    }
    
    @PostMapping("/saveDoctor")
    public String savedoctor(@ModelAttribute TblMedico TblMedico, RedirectAttributes redirectAttributes) {
        try {
            doctorService.registerDoctor(TblMedico);  
            redirectAttributes.addFlashAttribute("message", "Médico registrado exitosamente.");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error al registrar el médico.");
            redirectAttributes.addFlashAttribute("messageType", "danger");
        }
        return "redirect:/views/doctorList";
    }
    
    @GetMapping("/editDoctor/{id}")
    public String edit(@PathVariable("id") Integer doctorId, Model model) {
        TblMedico TblMedico = doctorService.getDoctorById(doctorId);
        model.addAttribute("TblMedico", TblMedico);
        return "views/modify";  
    }
    
    @GetMapping("/deleteDoctor/{id}")
    public String delete(@PathVariable("id") Integer doctorId, RedirectAttributes redirectAttributes) {
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