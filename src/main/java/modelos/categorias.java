package modelos;

public class categorias {
    private int id;
    private String nombre;
    private int edad_min;
    private int edad_max;
    private int anio_nacimiento;
    private int distancia;

    public categorias() {
    }

    public categorias(int id, String nombre, int edad_min, int edad_max, int anio_nacimiento, int distancia) {
        this.id = id;
        this.nombre = nombre;
        this.edad_min = edad_min;
        this.edad_max = edad_max;
        this.anio_nacimiento = anio_nacimiento;
        this.distancia = distancia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_min() {
        return edad_min;
    }

    public void setEdad_min(int edad_min) {
        this.edad_min = edad_min;
    }

    public int getEdad_max() {
        return edad_max;
    }

    public void setEdad_max(int edad_max) {
        this.edad_max = edad_max;
    }

    public int getAnio_nacimiento() {
        return anio_nacimiento;
    }

    public void setAnio_nacimiento(int anio_nacimiento) {
        this.anio_nacimiento = anio_nacimiento;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "categorias{" + "id=" + id + ", nombre=" + nombre + ", edad_min=" + edad_min + ", edad_max=" + edad_max + ", anio_nacimiento=" + anio_nacimiento + ", distancia=" + distancia + '}';
    }

    
}
