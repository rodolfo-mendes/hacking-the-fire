package hackingthefire.controllers.rest;

import hackingthefire.domain.Ocorrencia;
import hackingthefire.persistence.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciasController {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping
    public String nova(Model model){
        model.addAttribute("ocorrencia", new Ocorrencia());
        return "form-ocorrencia";
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String ocorrencia(
            @ModelAttribute("ocorrencia")
            @Valid
            Ocorrencia ocorrencia,
            BindingResult bindingResult,
            Model model){

        if(bindingResult.hasErrors()){
            return "form-ocorrencia";
        }

        ocorrencia.setMunicipio("Uberlândia");
        ocorrencia.setUf("MG");
        ocorrencia.setStatus("nao-atendido");

        ocorrenciaRepository.save(ocorrencia);

        model.addAttribute("ocorrencia", new Ocorrencia());
        model.addAttribute("message", "Ocorrência registrada com sucesso!");

        return "form-ocorrencia";
    }
}
