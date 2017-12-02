package hackingthefire.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Coordenadas implements Serializable{
    private BigDecimal latitude;
    private BigDecimal lagitude;

    public Coordenadas() {
    }

    public Coordenadas(BigDecimal latitude, BigDecimal lagitude) {
        this.latitude = latitude;
        this.lagitude = lagitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLagitude() {
        return lagitude;
    }

    public void setLagitude(BigDecimal lagitude) {
        this.lagitude = lagitude;
    }
}
