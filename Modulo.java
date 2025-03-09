import java.util.Arrays;

public class Modulo {
    private String nombre;
    private int capacidad;
    private String tipo;
    private Persona[] habitantes;

    public Modulo(String nombre, int capacidad, String tipo) {
        this.nombre = nombre;

        // Ensuring minimum capacity of 20
        if (capacidad >= 20) {
            this.capacidad = 20;
        } else {
            this.capacidad = capacidad;
        }
        this.tipo = tipo;
        this.habitantes = new Persona[this.capacidad];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad >= 20) {
            this.capacidad = 20;
        } else {
            this.capacidad = capacidad;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona[] getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Persona[] habitantes) {
        this.habitantes = new Persona[this.capacidad];
    }

    // Adding an inhabitant to the module
    public boolean agregarHabitantes(Persona persona) {
        for (int i = 0; i < habitantes.length; i++) {
            if (habitantes[i] == null) {
                habitantes[i] = persona;
                return true;
            }
        }
        return false; // No space available
    }

    // Removing an inhabitant from the module by name
    public boolean eliminarHabitantes(String nombre) {
        for (int i = 0; i < habitantes.length; i++) {
            if (habitantes[i] != null && habitantes[i].getNombre().equalsIgnoreCase(nombre)) {
                habitantes[i] = null;
                // Shift remaining inhabitants to fill the gap
                for (int j = i; j < habitantes.length - 1; j++) {
                    habitantes[j] = habitantes[j + 1];
                }
                habitantes[habitantes.length - 1] = null;
                return true;
            }
        }
        return false; // Inhabitant not found
    }

    // Listing all inhabitants in the module
    public void listarHabitantes() {
        for (int i = 0; i < habitantes.length; i++) {
            if (habitantes[i] != null) {
                System.out.printf("Habitante en posición %d :\nNombre-> %s\n", i + 1, habitantes[i].getNombre());
            }
        }
    }

    @Override
    public String toString() {
        return "Modulo [nombre=" + nombre + ", capacidad=" + capacidad + ", tipo=" + tipo + ", habitantes="
                + Arrays.toString(habitantes) + "]";
    }
}
