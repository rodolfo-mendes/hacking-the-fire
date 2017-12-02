package hackingthefire.service;

import hackingthefire.domain.Coordenadas;

public interface GeolocationService {
    public Coordenadas findCoordenadasByEndereco(
        String endereco,
        String numero,
        String bairro,
        String municipio,
        String uf
    );
}
