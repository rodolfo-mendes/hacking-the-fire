package hackingthefire.service;

import hackingthefire.domain.Coordenadas;
import hackingthefire.service.dto.GoogleGeolocationResponse;
import hackingthefire.service.dto.Location;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Component
@Scope("prototype")
public class GoogleGeolocationService implements GeolocationService{
    @Override
    public Coordenadas findCoordenadasByEndereco(String endereco, String numero, String bairro, String municipio, String uf) {
        RestTemplate restTemplate = new RestTemplate();

        String enderecoCompleto = MessageFormat.format(
                "{0} {1}, {2}, {3}, {4}",
                numero,
                endereco,
                municipio,
                uf,
                "Brasil"
        );

        String url = "https://maps.googleapis.com/maps/api/geocode/json?address={address}&key={apiKey}";
        String apiKey = "AIzaSyCjSMzf5f9iV8keaXuGAVoGXbcNKvfDbcw";

        GoogleGeolocationResponse response = restTemplate
                .getForObject(url, GoogleGeolocationResponse.class, enderecoCompleto, apiKey);

        if(response.getResults().isEmpty()){
            throw new RuntimeException("Não foi possível localizar coordenadas do endereço.");
        }

        Location location = response.getResults().get(0).getGeometry().getLocation();

        return new Coordenadas(
            location.getLatitude(),
            location.getLongitude()
        );
    }
}
