package com.kllm.practicaut8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.kllm.practicaut8.model.*;
import com.kllm.practicaut8.repository.*;

@Controller
public class AppController {

    @Autowired private ActividadRepository actRepo;
    @Autowired private ParticipanteRepository partRepo;

    @GetMapping("/inicio")
    public String inicio() { return "inicio"; }

    @GetMapping("/listadoActividades")
    public String listAct(Model m) {
        m.addAttribute("actividades", actRepo.findAll());
        return "listado-actividades";
    }

    @GetMapping("/listadoParticipantes")
    public String listPart(Model m) {
        m.addAttribute("participantes", partRepo.findAll());
        return "listado-participantes";
    }

    @GetMapping("/altaActividad")
    public String formAct(Model m) {
        m.addAttribute("actividad", new Actividad());
        return "form-actividad";
    }

    @PostMapping("/guardarActividad")
    public String saveAct(Actividad a) {
        actRepo.save(a);
        return "redirect:/listadoActividades";
    }

    @GetMapping("/altaParticipante")
    public String formPart(Model m) {
        m.addAttribute("participante", new Participante());
        m.addAttribute("actividades", actRepo.findAll());
        return "form-participante";
    }

    @PostMapping("/guardarParticipante")
    public String savePart(Participante p) {
        partRepo.save(p);
        return "redirect:/listadoParticipantes";
    }
}