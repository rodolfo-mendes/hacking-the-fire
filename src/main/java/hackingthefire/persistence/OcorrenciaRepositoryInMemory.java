package hackingthefire.persistence;

import hackingthefire.domain.ocorrencia.Ocorrencia;
import hackingthefire.domain.ocorrencia.OcorrenciaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@ApplicationScope
@Repository
public class OcorrenciaRepositoryInMemory implements OcorrenciaRepository{
    private List<Ocorrencia> ocorrencias = new ArrayList<>();

    @Override
    public void add(Ocorrencia ocorrencia) {
        ocorrencias.add(ocorrencia);
    }

    @Override
    public List<Ocorrencia> findAll() {
        return new ArrayList<>(ocorrencias);
    }
}
