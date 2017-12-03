package hackingthefire.controllers.rest;

import hackingthefire.domain.Atendimento;
import hackingthefire.persistence.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @GetMapping
    public List<Atendimento> find(
            @RequestParam(value = "recurso", required = false) String recurso){
        Atendimento atendimento = new Atendimento();

        atendimento.setNome("Maria das Dores");
        atendimento.setSexo("feminino");
        atendimento.setIdade(40);
        atendimento.setEndereco("Av. Floriano Peixoto");
        atendimento.setNumero("1500");
        atendimento.setBairro("Centro");
        atendimento.setLatitude(BigDecimal.valueOf(-40.00));
        atendimento.setLatitude(BigDecimal.valueOf(-20.00));

        Atendimento atendimento2 = new Atendimento();
        atendimento2.setNome("José Peixoto");
        atendimento2.setSexo("masculino");
        atendimento2.setIdade(40);
        atendimento2.setEndereco("Av. Floriano Peixoto");
        atendimento2.setNumero("1500");
        atendimento2.setBairro("Centro");
        atendimento2.setLatitude(BigDecimal.valueOf(-40.01));
        atendimento2.setLatitude(BigDecimal.valueOf(-20.02));

        return Arrays.asList(atendimento, atendimento2);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Atendimento atendimento){
        atendimentoRepository.save(atendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
