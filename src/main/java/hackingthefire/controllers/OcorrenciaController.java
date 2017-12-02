package hackingthefire.controllers;

import hackingthefire.domain.ocorrencia.Ocorrencia;
import hackingthefire.persistence.OcorrenciaRepository;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping
    public List<Ocorrencia> findAll(
            @RequestParam(value = "status", required = false, defaultValue = "")
            String status) {

        if(status != null && !status.trim().isEmpty()){
            return ocorrenciaRepository.findByStatus(status);
        }

        return ocorrenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ocorrencia findById(@PathVariable("id") String id){
        return ocorrenciaRepository.findById(id);
    }

    @PutMapping("/{id}")
    public void updateById(
            @PathVariable("id") String id,
            @RequestBody Ocorrencia ocorrencia){

        Ocorrencia ocorrenciaDb = ocorrenciaRepository.findById(id);

        try {
            Map<String, Object> properties = PropertyUtils.describe(ocorrencia);
            properties.values().removeIf(Objects::isNull);
            properties.remove("class");
            properties.entrySet().forEach(e -> {
                try {
                    PropertyUtils.setProperty(ocorrenciaDb, e.getKey(), e.getValue());
                } catch (Exception ex) {
                    throw new RuntimeException("Erro ao ler propriedades da ocorrencia", ex);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler propriedades da ocorrencia", e);
        }

        ocorrenciaRepository.save(ocorrenciaDb);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody  Ocorrencia ocorrencia){
        ocorrencia.setStatus("nao-atendido");
        ocorrenciaRepository.save(ocorrencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}