package hackingthefire.controllers.rest;

import hackingthefire.domain.Ocorrencia;
import hackingthefire.persistence.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciasController {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping("/nova")
    public String nova(Model model){
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "form-ocorrencia";
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String ocorrencia(@ModelAttribute("ocorrencia") Ocorrencia ocorrencia){
        ocorrencia.setMunicipio("Uberlândia");
        ocorrencia.setUf("MG");
        ocorrencia.setStatus("nao-atendido");

        ocorrenciaRepository.save(ocorrencia);

        return "form-ocorrencia";
    }
}
