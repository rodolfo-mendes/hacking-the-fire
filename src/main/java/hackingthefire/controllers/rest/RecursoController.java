package hackingthefire.controllers.rest;

import hackingthefire.domain.Recurso;
import hackingthefire.persistence.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {
    @Autowired
    private RecursoRepository recursoRepository;

    @GetMapping
    public List<Recurso> find(
        @RequestParam(value = "tipo", required = false, defaultValue = "")
        String tipo,
        @RequestParam(value = "status", required = false, defaultValue = "")
        String status
    ){
        Recurso recursoComTipoStatus = new Recurso();
        recursoComTipoStatus.setTipo(tipo);
        recursoComTipoStatus.setStatus(status);

        //centro
        //-18.9442608
        //-48.2970356

        Recurso recurso1 = new Recurso();
        recurso1.setDescricao("carro-resgate-01");
        recurso1.setLatitude(BigDecimal.valueOf(-18.9452608));
        recurso1.setLongitude(BigDecimal.valueOf(-48.2870356));

        Recurso recurso2 = new Recurso();
        recurso2.setDescricao("ambulancia-01");
        recurso2.setLatitude(BigDecimal.valueOf(-18.9422608));
        recurso2.setLongitude(BigDecimal.valueOf(-48.2670356));

        Recurso recurso3 = new Recurso();
        recurso3.setDescricao("ambulancia-02");
        recurso3.setLatitude(BigDecimal.valueOf(-18.9420608));
        recurso3.setLongitude(BigDecimal.valueOf(-48.2650356));

        return Arrays.asList(recurso1, recurso2, recurso3);

        //return recursoRepository.findAl(Example.of(recursoComTipoStatus));
    }
}
