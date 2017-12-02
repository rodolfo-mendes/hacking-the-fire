package hackingthefire.service;

import hackingthefire.domain.Coordenadas;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoogleGeolocationServiceTest {
    @Autowired
    private GoogleGeolocationService service;

    @Test
    public void findEnderecoTest(){
        Coordenadas coordenadas = service
            .findCoordenadasByEndereco("alameda serra dourada", "140", "Cidade Jardim", "Uberlândia", "MG");

        Assert.assertNotNull(coordenadas);

    }
}
