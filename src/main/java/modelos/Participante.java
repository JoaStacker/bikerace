package modelos;
import java.time.LocalTime;

public class Participante {
    private int placa;
    private int categoria;
    private int distancia;
    private LocalTime tiempo;

    public Participante() {
    }

    public Participante(int placa, int categoria, int distancia, LocalTime tiempo) {
        this.placa = placa;
        this.categoria = categoria;
        this.distancia = distancia;
        this.tiempo = tiempo;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Participante{" + "placa=" + placa + ", categoria=" + categoria + ", distancia=" + distancia + ", tiempo=" + tiempo + '}';
    }

    
}
