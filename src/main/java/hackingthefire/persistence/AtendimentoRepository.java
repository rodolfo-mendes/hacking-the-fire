package hackingthefire.persistence;

import hackingthefire.domain.Atendimento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AtendimentoRepository extends MongoRepository<Atendimento, String>{

    Atendimento findByRecurso(String recurso);
}
