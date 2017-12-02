package hackingthefire.controllers;

import hackingthefire.domain.ocorrencia.Atendimento;
import hackingthefire.persistence.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @GetMapping
    public List<Atendimento> findAll(){
        return atendimentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Atendimento atendimento){
        atendimentoRepository.save(atendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
