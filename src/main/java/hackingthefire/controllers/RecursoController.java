package hackingthefire.controllers;

import hackingthefire.domain.Recurso;
import hackingthefire.persistence.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {
    @Autowired
    private RecursoRepository recursoRepository;

    @GetMapping
    public List<Recurso> find(
            @RequestParam(value = "tipo", required = false, defaultValue = "")
            String tipo){

        if(tipo != null && !tipo.trim().isEmpty()){
            return recursoRepository.findByTipo(tipo);
        }

        return recursoRepository.findAll();
    }
}
