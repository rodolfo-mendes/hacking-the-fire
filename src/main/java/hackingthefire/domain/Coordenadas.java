package hackingthefire.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Coordenadas implements Serializable{
    private String nomePaciente;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Coordenadas() {
    }

    public Coordenadas(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
}
