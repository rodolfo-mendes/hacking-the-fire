package hackingthefire.controllers.rest;

import hackingthefire.domain.Atendimento;
import hackingthefire.domain.Ocorrencia;
import hackingthefire.domain.Recurso;
import hackingthefire.persistence.AtendimentoRepository;
import hackingthefire.persistence.OcorrenciaRepository;
import hackingthefire.persistence.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private RecursoRepository recursoRepository;

    @GetMapping
    public List<Atendimento> find(
            @RequestParam(value = "recurso", required = false) String recurso){
        return atendimentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity create(
            @RequestParam("ocorrencia")
            String idOcorrencia,
            @RequestParam("recurso")
            String idRecurso){


        Ocorrencia ocorrencia = ocorrenciaRepository.findById(idOcorrencia);

        Recurso recurso = recursoRepository.findById(idRecurso);

        Atendimento atendimento = new Atendimento();
        atendimento.setIdRecurso(recurso.getId());
        atendimento.setDescricaoRecurso(recurso.getDescricao());
        atendimento.setIdOcorrencia(ocorrencia.getId());
        atendimento.setNome(ocorrencia.getNomePaciente());
        atendimento.setSexo(ocorrencia.getSexo());
        atendimento.setIdade(ocorrencia.getIdade());
        atendimento.setEndereco(ocorrencia.getEndereco());
        atendimento.setNumero(ocorrencia.getNumero());
        atendimento.setBairro(ocorrencia.getBairro());
        atendimento.setLatitude(ocorrencia.getLatitude());
        atendimento.setLongitude(ocorrencia.getLongitude());
        atendimentoRepository.save(atendimento);

        ocorrencia.setStatus("em-atendimento");
        ocorrenciaRepository.save(ocorrencia);

        recurso.setStatus("em-atendimento");
        recursoRepository.save(recurso);

        Map<String,String> dadosRetorno = new HashMap<>();
        dadosRetorno.put("nomePaciente", atendimento.getNome());
        dadosRetorno.put("descricaoRecurso", atendimento.getDescricaoRecurso());

        return ResponseEntity.status(HttpStatus.CREATED).body(dadosRetorno);
    }
}
