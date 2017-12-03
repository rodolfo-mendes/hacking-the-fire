package hackingthefire.persistence;

import hackingthefire.domain.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecursoRepository extends MongoRepository<Recurso, String>{
    List<Recurso> findByTipo(String tipo);

    List<Recurso> findByTipoAndStatus(String tipo , String status);

    Recurso findById(String idRecurso);
}
