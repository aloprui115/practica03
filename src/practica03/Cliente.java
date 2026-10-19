package practica03;

public class Cliente {
    private int numero;
    private String nombre;
    private int edad;

    public Cliente(int numero, String nombre, int edad) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
