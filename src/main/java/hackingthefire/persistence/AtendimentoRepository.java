package hackingthefire.persistence;

import hackingthefire.domain.ocorrencia.Atendimento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AtendimentoRepository extends MongoRepository<Atendimento, String>{

}
