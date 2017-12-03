package hackingthefire.controllers.rest;

import hackingthefire.domain.Ocorrencia;
import hackingthefire.persistence.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.MessageFormat;
import java.util.List;

@Controller
@RequestMapping("/despacho")
public class DespachoController {
    private static int MAX_OCORRENCIAS_NAO_ATENDIDAS = 5;

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping
    public String despachos(Model model){
        //TODO: trazer maximo já do banco de dados
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findByStatus("nao-atendido");
        int numeroOcorrencias = Math.min(ocorrencias.size(), MAX_OCORRENCIAS_NAO_ATENDIDAS);

        String q = "140 alameda serra dourada, uberlândia, mg, brazil";
        String apiKey = "AIzaSyCrWIz2HFJ0I7tP6lEgBrqi4si2CO7yWSs";

        String urlMapa = MessageFormat.format(
            "https://www.google.com/maps/embed/v1/search?q={0}&key={1}",
            q,
            apiKey);

        model.addAttribute("ocorrenciasNaoAtendidas", ocorrencias.subList(0, numeroOcorrencias));
        model.addAttribute("urlMapa", urlMapa);

        return "despacho";
    }
}
