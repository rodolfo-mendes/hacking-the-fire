package hackingthefire.persistence;

import hackingthefire.domain.Ocorrencia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OcorrenciaRepository extends MongoRepository<Ocorrencia,String> {
    List<Ocorrencia> findByStatus(String status);

    Ocorrencia findById(String id);
}
