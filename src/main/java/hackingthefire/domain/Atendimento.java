package hackingthefire.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "atendimentos")
public class Atendimento {
    @Id
    private String id;
}
