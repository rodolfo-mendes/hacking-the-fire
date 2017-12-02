package hackingthefire.controllers;

import hackingthefire.domain.ocorrencia.Ocorrencia;
import hackingthefire.domain.ocorrencia.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping
    public List<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody  Ocorrencia ocorrencia){
        ocorrenciaRepository.add(ocorrencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}