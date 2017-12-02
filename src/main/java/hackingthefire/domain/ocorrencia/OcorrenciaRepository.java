package hackingthefire.domain.ocorrencia;

import java.util.List;

public interface OcorrenciaRepository {
    void add(Ocorrencia ocorrencia);

    List<Ocorrencia> findAll();
}
