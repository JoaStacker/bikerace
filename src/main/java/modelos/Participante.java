package modelos;
import java.time.LocalTime;

public class Participante {
    private int placa;
    private int categoria;
    private int distancia;
    private long tiempo;
    private boolean en_carrera;
    private LocalTime hora_inicio;

    public Participante() {
    }

    public Participante(int placa, int categoria, int distancia) {
        this.placa = placa;
        this.categoria = categoria;
        this.distancia = distancia;
    }
    
    public Participante(int placa, int categoria, int distancia, long tiempo) {
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

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }
    
    public void setEnCarrera(boolean en_carrera){
        this.en_carrera = en_carrera;
    }
    
    public boolean getEnCarrera(){
        return this.en_carrera;
    }
    
    public LocalTime getTiempoInicio(){
        return this.hora_inicio;
    }
    
    public void setTiempoInicio(LocalTime hora_inicio){
        this.hora_inicio = hora_inicio;
    }

    @Override
    public String toString() {
        return "Participante{" + "placa=" + placa + ", categoria=" + categoria + ", distancia=" + distancia + ", tiempo=" + tiempo + '}';
    }

    
}
