package hackingthefire.persistence;

import hackingthefire.domain.ocorrencia.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecursoRepository extends MongoRepository<Recurso, String>{
    public List<Recurso> findByTipo(String tipo);
}
